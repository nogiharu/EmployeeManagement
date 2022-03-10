package com.example.semaple20220309.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;

import com.example.semaple20220309.dto.Calculation;
import com.example.semaple20220309.entity.Department;
import com.example.semaple20220309.entity.Department_;
import com.example.semaple20220309.entity.Task;
import com.example.semaple20220309.entity.Task_;
import com.example.semaple20220309.repository.DepartmentRepository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CalculationDAOImpl implements CalculationDAO {

    private final EntityManager em;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Calculation> findByCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Calculation> query = cb.createQuery(Calculation.class);
        Root<Department> root = query.from(Department.class);
        //Join<>
        // ------------------------------------------------------
        Path<Integer> SALSE = root.get(Task_.SALES);
        Path<Boolean> DELETE_FLG = root.get(Task_.DELETE_FLG);
        Path<Integer> DEPARTMENT = root.get(Department_.ID);
        Order ASC = cb.asc(DEPARTMENT);
        // ------------------------------------------------------
        query.select(cb.construct(Calculation.class,
                cb.sum(SALSE),
                cb.avg(SALSE),
                cb.count(DELETE_FLG)));
        // -------------------------------------------------------------
        query = query.where(DELETE_FLG).groupBy(DEPARTMENT).orderBy(ASC);

        return em.createQuery(query).getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Calculation> findByJPQL() {
       // select d.name ,d.id, COALESCE(SUM(t.sales),0),COALESCE(AVG(t.sales),0),count(t.delete_flg) from department d left join task t on d.id = t.department_id group by d.id order by d.id asc;
                String query = 
                "SELECT NEW com.example.semaple20220309.dto.Calculation("
                +" d.name, d.id,"
                +" SUM(CASE WHEN t.deleteFlg = true THEN t.sales ELSE 0 END),"
                +" AVG(CASE WHEN t.deleteFlg = true THEN t.sales ELSE 0 END),"
                +" COUNT(CASE WHEN t.deleteFlg = true THEN t.deleteFlg ELSE NULL END))"
                +" FROM Department d"
                +" LEFT JOIN Task t ON d.id = t.department"
                +" GROUP BY d.id"
                +" ORDER BY d.id ASC";
        return em.createQuery(query).getResultList();

    }
}
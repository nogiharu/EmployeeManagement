package com.example.semaple20220309.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;

import com.example.semaple20220309.dto.Calculation;

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
        Root<Task> root = query.from(Task.class);
        // ------------------------------------------------------
        Path<Integer> SALSE = root.get(Task_.SALES);
        Path<Boolean> DELETE_FLG = root.get(Task_.DELETE_FLG);
        Path<Integer> DEPARTMENT = root.get(Task_.DEPARTMENT);
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
        //select d.name , sum(t.sales),round(avg(t.sales)),count(t.delete_flg) from task t left join department d on d.id = t.department_id group by t.department_id order by d.id asc;

          
    String query = "SELECT NEW com.example.semaple20220309.dto.Calculation("
                +"d.name, d.id, COALESCE(SUM(t.sales),0), COALESCE(AVG(t.sales),0), COUNT(t.deleteFlg))"
                +" FROM Department d LEFT JOIN Task t on d.id = t.department WHERE t.deleteFlg = true GROUP BY t.department ORDER BY d.id ASC";
                return em.createQuery(query).getResultList();
            
    
    }
}
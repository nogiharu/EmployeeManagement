package com.example.seamaple_20220305.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.example.seamaple_20220305.dto.Calc;
import com.example.seamaple_20220305.entity.Task;
import com.example.seamaple_20220305.entity.Task_;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class CalcrationDAOImpl implements CalcrationDAO {
    // select sum(sales) as total, round(avg(sales)) as avrage,count(delete_flg) as
    // counts from task where delete_flg group by department_id;

    private final EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Calc> JPQL() {
        String query = "SELECT NEW com.example.seamaple_20220305.dto.Calc( SUM(t.sales)) FROM Task t";
                Query QE = em.createQuery(query);
        return QE.getResultList();

    }

    @Override
    public List<Calc> criteria() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Calc> query = cb.createQuery(Calc.class);
        Root<Task> root = query.from(Task.class);
        // ----------------------------------------------------------
        Path<Integer> SALSE = root.get(Task_.SALES);
        Path<Boolean> DELETE_FLG = root.get(Task_.DELETE_FLG);
        Path<Integer> DEPARTMENT = root.get(Task_.DEPARTMENT);
        Order ASC = cb.asc(DEPARTMENT);
        // --------------------------------------------------
        query.select(cb.construct(Calc.class, cb.sum(SALSE), cb.avg(SALSE), cb.count(DELETE_FLG)));
        // -------------------------------------------------------------
        query = query.where(DELETE_FLG).groupBy(DEPARTMENT).orderBy(ASC);

        List<Calc> calc = em.createQuery(query).getResultList();
        return calc;
    }

    @SuppressWarnings("unchecked")
    public Calc list() {

        final String _query_total = "select sum(sales) from task where delete_flg group by department_id;";
        final String _query_average = "select round(avg(sales)) from task where delete_flg group by department_id;";
        final String _query_count = "select count(delete_flg) from task where delete_flg group by department_id;";

        // Calc calc = new Calc();

        // calc.setTotal(entityManager.createNativeQuery(_query_total).getResultList());
        // calc.setAverage(entityManager.createNativeQuery(_query_average).getResultList());
        // calc.setCounts(entityManager.createNativeQuery(_query_count).getResultList());
        return null;
    }
}
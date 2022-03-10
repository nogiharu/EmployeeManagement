package com.example.semaple20220309.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.semaple20220309.entity.Employee;
import com.example.semaple20220309.entity.Employee_;
import com.example.semaple20220309.form.EmployeeQuery;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Override
    public List<Employee> findByCriteria(EmployeeQuery employeeQuery) {
        // ------------------------------------------------------------------------------------
        // クエリの準備
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        List<Predicate> list = new ArrayList<>();
        Optional<EmployeeQuery> employee = Optional.of(employeeQuery);
        // ------------------------------------------------------------------------------------
        // 【性別】初期値でないことを判定 => イコール指定後,Predicate型に変換 => リストに追加
        employee
                .filter(emp -> emp.getGender() != -1)
                .map(emp -> cb.equal(root.get(Employee_.GENDER), emp.getGender()))
                .ifPresent(list::add);

        // 【メールアドレス】
        // %に変換 -> LIKE指定後,Predicate型に変換 => リストに追加
        employee
                .map(emp -> "%" + emp.getEmail() + "%")
                .map(emp -> cb.like(root.get(Employee_.EMAIL), emp))
                .ifPresent(list::add);

        // 【入社年月日：開始】
        // null判定 => SQLDate型に変換 => "開始～"指定後,Predicate型に変換 => リストに追加
        employee.filter(emp -> emp.getDateFrom() != null)
                .map(emp -> Date.valueOf(emp.getDateFrom()))
                .map(dateFrom -> cb.greaterThanOrEqualTo(root.get(Employee_.REGIST_DATE), dateFrom))
                .ifPresent(list::add);

        // 【入社年月日：終了】
        // null判定 => SQLDate型に変換 => "～終了"指定後,Predicate型に変換 => リストに追加
        employee.filter(emp -> emp.getDateTo() != null)
                .map(emp -> Date.valueOf(emp.getDateTo()))
                .map(dateTo -> cb.lessThanOrEqualTo(root.get(Employee_.REGIST_DATE), dateTo))
                .ifPresent(list::add);
        // ------------------------------------------------------------------------------------
        // クエリをセット
        query = query.select(root).where(list.toArray(Predicate[]::new));
        // クエリ実行
        return entityManager.createQuery(query).getResultList();
    }
}
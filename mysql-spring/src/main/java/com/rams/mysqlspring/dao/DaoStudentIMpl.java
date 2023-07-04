package com.rams.mysqlspring.dao;

import com.rams.mysqlspring.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoStudentIMpl implements DaoStudent{
    private EntityManager entityManager;
    public DaoStudentIMpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<StudentEntity> readAll() {
        TypedQuery<StudentEntity> theQuery=entityManager.createQuery("FROM StudentEntity",StudentEntity.class);
        return theQuery.getResultList();
    }

    @Override
    public List<StudentEntity> readStudentByName(String firstName) {
        TypedQuery<StudentEntity> theQuery=entityManager.createQuery(("FROM StudentEntity WHERE firstName=:nameStudent"),StudentEntity.class);
        theQuery.setParameter("nameStudent",firstName);
        List<StudentEntity> listStudent=theQuery.getResultList();
        return listStudent;
    }

    @Override
    @Transactional
    public StudentEntity writeDatabase(StudentEntity studentEntity) {
        StudentEntity studentCurrent=entityManager.merge(studentEntity);
        return studentCurrent;
    }
}

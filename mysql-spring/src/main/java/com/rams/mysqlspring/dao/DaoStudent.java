package com.rams.mysqlspring.dao;

import com.rams.mysqlspring.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoStudent {
    List<StudentEntity> readAll();
    StudentEntity readStudentByName(String firstName);
    StudentEntity writeDatabase();

}

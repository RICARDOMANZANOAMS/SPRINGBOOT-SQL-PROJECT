package com.rams.mysqlspring.service;

import com.rams.mysqlspring.entity.StudentEntity;

import java.util.List;

public interface ServiceStudent {
    List<StudentEntity> readAll();
    List<StudentEntity> readStudentByName(String firstName);
    StudentEntity writeDatabase(StudentEntity studentEntity);
}

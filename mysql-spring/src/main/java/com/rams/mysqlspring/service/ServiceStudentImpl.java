package com.rams.mysqlspring.service;

import com.rams.mysqlspring.dao.DaoStudent;
import com.rams.mysqlspring.dao.DaoStudentIMpl;
import com.rams.mysqlspring.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceStudentImpl implements ServiceStudent{

    private DaoStudent daoStudent;

    public ServiceStudentImpl(DaoStudent theDaoStudent){
        daoStudent=theDaoStudent;

    }
    @Override
    public List<StudentEntity> readAll() {
        return daoStudent.readAll();
    }

    @Override
    public List<StudentEntity> readStudentByName(String firstName) {
        return daoStudent.readStudentByName( firstName);
    }
    @Transactional
    @Override
    public StudentEntity writeDatabase(StudentEntity studentEntity) {
        return daoStudent.writeDatabase(studentEntity);
    }
}

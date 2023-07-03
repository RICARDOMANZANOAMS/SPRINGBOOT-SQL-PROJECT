package com.rams.mysqlspring.rest;

import com.rams.mysqlspring.dao.DaoStudent;
import com.rams.mysqlspring.entity.StudentEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestControllerStudent {
    private DaoStudent daoStudent;
    public RestControllerStudent(DaoStudent theDaoStudent){
        daoStudent=theDaoStudent;
    }

    @PostMapping("/students")
    public StudentEntity saveStudent(@RequestBody StudentEntity theStudentEntity){
        theStudentEntity.setId(0);
        StudentEntity resultStudentEntity=daoStudent.writeDatabase(theStudentEntity);
        return resultStudentEntity;

    }

    @GetMapping("/students")
    public List<StudentEntity> getStudents(){
        List<StudentEntity> resultGetStudents=daoStudent.readAll();
        return resultGetStudents;
    }

    @GetMapping("/students/{studentName}")
    public List<StudentEntity> getStudentByName(@PathVariable String studentName){
        List<StudentEntity> resultGetStudentsByFirstName=daoStudent.readStudentByName(studentName);
        return resultGetStudentsByFirstName;
    }

    }


package com.rams.mysqlspring.rest;

import com.rams.mysqlspring.dao.DaoStudent;
import com.rams.mysqlspring.entity.StudentEntity;
import com.rams.mysqlspring.service.ServiceStudent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestControllerStudent {
    private ServiceStudent serviceStudent;
    public RestControllerStudent(ServiceStudent theServiceStudent){
        serviceStudent=theServiceStudent;
    }

    @PostMapping("/students")
    public StudentEntity saveStudent(@RequestBody StudentEntity theStudentEntity){
        theStudentEntity.setId(0);
        StudentEntity resultStudentEntity=serviceStudent.writeDatabase(theStudentEntity);
        return resultStudentEntity;

    }

    @GetMapping("/students")
    public List<StudentEntity> getStudents(){
        List<StudentEntity> resultGetStudents=serviceStudent.readAll();
        return resultGetStudents;
    }

    @GetMapping("/students/{studentName}")
    public List<StudentEntity> getStudentByName(@PathVariable String studentName){
        List<StudentEntity> resultGetStudentsByFirstName=serviceStudent.readStudentByName(studentName);
        return resultGetStudentsByFirstName;
    }

    }


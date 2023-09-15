package com.codegym.demo_springdatajpa_a10.controller;

import com.codegym.demo_springdatajpa_a10.dto.StudentDto;
import com.codegym.demo_springdatajpa_a10.model.Student;
import com.codegym.demo_springdatajpa_a10.service.IServiceStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student")
public class RestStudentController {
    @Autowired
    private IServiceStudent serviceStudent;
    @GetMapping("")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList  = serviceStudent.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(studentList,HttpStatus.OK);
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto){
         // validate
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        boolean check =serviceStudent.add(student);
        if (check){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody StudentDto studentDto){
        Student student = serviceStudent.findById(id);
        if (student ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentDto,student);
        serviceStudent.update(student);
        return new ResponseEntity<>("Update success", HttpStatus.OK);
    }
}

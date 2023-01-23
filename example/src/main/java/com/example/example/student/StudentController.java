package com.example.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentservice;
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }
    @RequestMapping(value = "/students/{id}",method=RequestMethod.PUT)
    public void updateStudent(@PathVariable Long id,@RequestBody Student student){
        studentservice.updateStudent(id,student);
    }
    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long id){
        studentservice.deleteStudent(id);
    }
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentservice.addStudent(student);
    }
    @RequestMapping(value = "students/{id}",method = RequestMethod.GET)
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentservice.getStudentById(id);
    }
}


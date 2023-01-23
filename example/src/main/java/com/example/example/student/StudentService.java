package com.example.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentrepository;

    public List<Student> getAllStudents(){
        List students=new ArrayList();
        studentrepository.findAll().forEach(students::add);
         return students;
    }

    public void deleteStudent(Long id){
        studentrepository.deleteById(id);
    }

    public void updateStudent(Long id,Student student){
        Student stu=studentrepository.findById(id).orElseThrow(()-> new IllegalStateException("Student id not found"));
        stu.setName(student.getName());
        stu.setDepartment(student.getDepartment());
        studentrepository.save(stu);
    }
    public void addStudent(Student student){
        studentrepository.save(student);
    }

    public Optional<Student> getStudentById(Long id){
        return studentrepository.findById(id);
    }
}

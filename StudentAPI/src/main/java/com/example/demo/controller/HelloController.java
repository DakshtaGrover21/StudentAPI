package com.example.demo.controller;


//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;


import com.example.demo.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class HelloController {
	
	@Autowired
	private StudentService studentService;
	
//	private List<Student> students = new ArrayList<>(
//		    Arrays.asList(
//		        new Student(1, "Dakshta", 95),
//		        new Student(2, "Navin", 80),
//		        new Student(3, "Rahul", 88)
//		    )
//		);

    @GetMapping("/hello")
    public String hello() {
        return "Hello Dakshta! My first API is working.";
    }
    
    @GetMapping("/students")
    public List<Student> getStudents() {
//        return students;
    	return studentService.getStudents();

}
    
//    @PostMapping("/students")
//    public Student addStudent(@RequestBody Student student) {
//        students.add(student);
//        return student;
//    }
    
//    @PostMapping("/students")
//    public Student addStudent(@RequestBody Student student) {
//        return studentService.addStudent(student);
//    }
    
    
    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    
//    @GetMapping("/students/{id}")
//    public Student getStudentById(@PathVariable int id) {
//
//        for (Student student : students) {
//
//            if (student.getId() == id) {
//                return student;
//            }
//        }
//
//        return null;
//    }
    
    
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    
    
//    @PutMapping("/students/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
//
//        for (Student student : students) {
//
//            if (student.getId() == id) {
//
//                student.setName(updatedStudent.getName());
//                student.setMarks(updatedStudent.getMarks());
//
//                return student;
//            }
//        }
//
//        return null;
//    }
    
//    @PutMapping("/students/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
//        return studentService.updateStudent(id, updatedStudent);
//    }
    
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @Valid @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }
    
    
//    @DeleteMapping("/students/{id}")
//    public String deleteStudent(@PathVariable int id) {
//
//        for (Student student : students) {
//
//            if (student.getId() == id) {
//
//                students.remove(student);
//                return "Student deleted successfully";
//            }
//        }
//
//        return "Student not found";
//    }
    
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}






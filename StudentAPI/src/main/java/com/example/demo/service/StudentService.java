package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
//	private List<Student> students = new ArrayList<>(
//	        Arrays.asList(
//	            new Student(1, "Dakshta", 95),
//	            new Student(2, "Navin", 80),
//	            new Student(3, "Rahul", 88)
//	        )
//	);
	
//	public List<Student> getStudents() {
//	    return students;
//	}
	
	public List<Student> getStudents() {
	    return studentRepository.findAll();
	}
	
	
	public Student addStudent(Student student) {
//	    students.add(student);
		return studentRepository.save(student);
//	    return student;
	}
	
	
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	

//	    for (Student student : students) {

//	        if (student.getId() == id) {
//	            return student;
//	        }
//	    }
//
//	    return null;
//	}
	
	public Student updateStudent(int id, Student updatedStudent) {

//	    for (Student student : students) {
		
		Student student = studentRepository.findById(id).orElse(null);

//	        if (student.getId() == id) {
		
		if (student != null) {

	            student.setName(updatedStudent.getName());
	            student.setMarks(updatedStudent.getMarks());
	            
	            
	            return studentRepository.save(student);
	        }
		
	    return null;
	}
	
//	public String deleteStudent(int id) {
//
//	    for (Student student : students) {
//
//	        if (student.getId() == id) {
//
//	            students.remove(student);
//	            return "Student deleted successfully";
//	        }
//	    }
//
//	    return "Student not found";
//	}
	
	public String deleteStudent(int id) {

//	    for (int i = 0; i < students.size(); i++) {
		
		Student student = studentRepository.findById(id).orElse(null);
		
		if (student != null) {

//	        if (students.get(i).getId() == id) {

//	            students.remove(i);
			
			studentRepository.delete(student);
	            return "Student deleted successfully";
	        
	    }

	    return "Student not found";
	}

}

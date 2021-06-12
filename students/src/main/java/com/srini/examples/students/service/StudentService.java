package com.srini.examples.students.service;

import org.springframework.http.ResponseEntity;

import com.srini.examples.students.dto.StudentDto;



public interface StudentService {
	
	public ResponseEntity<StudentDto> addStudent(StudentDto studentDto);
	
	public ResponseEntity<StudentDto> getStudent(Long studentId);

}

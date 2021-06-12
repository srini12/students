package com.srini.examples.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.examples.students.dto.StudentDto;
import com.srini.examples.students.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}

	@GetMapping("/get/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
		return studentService.getStudent(studentId);
	}

}

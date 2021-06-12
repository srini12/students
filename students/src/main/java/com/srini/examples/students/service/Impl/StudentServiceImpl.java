package com.srini.examples.students.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.srini.examples.students.dto.StudentDto;
import com.srini.examples.students.entities.Student;
import com.srini.examples.students.exceptions.ResourceNotFoundException;
import com.srini.examples.students.repository.StudentRepository;
import com.srini.examples.students.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<StudentDto> addStudent(StudentDto studentDto) {
		Student student = getStudentEntity(studentDto);
		Student studentResponse = studentRepository.save(student);
		StudentDto studentDtoResponse = getStudentDto(studentResponse);
		return new ResponseEntity<>(studentDtoResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentDto> getStudent(Long studentId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" + studentId));
		return new ResponseEntity<>(getStudentDto(student), HttpStatus.OK);
	}

	private StudentDto getStudentDto(Student studentResponse) {
		return StudentDto.builder().studentAge(studentResponse.getStudentAge())
				.studentId(studentResponse.getStudentId()).studentName(studentResponse.getStudentName()).build();
	}

	private Student getStudentEntity(StudentDto studentDto) {
		return Student.builder().studentId(studentDto.getStudentId()).studentName(studentDto.getStudentName())
				.studentAge(studentDto.getStudentAge()).build();
	}

}

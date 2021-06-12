package com.srini.examples.students.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

	private Long studentId;
	private String studentName;
	private String studentAge;

}

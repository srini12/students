package com.srini.examples.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srini.examples.students.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}

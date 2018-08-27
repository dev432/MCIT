package com.jim.service;

import java.util.List;

import com.jim.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theStudentId);

	public void deleteStudent(int theStudentId);
}

package com.jim.dao;

import java.util.List;

import com.jim.entity.Student;


public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theStudentId);

	public void deleteStudent(int theStudentId);
}

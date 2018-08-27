package com.jim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jim.dao.StudentDAO;
import com.jim.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDAO.saveStudent(theStudent);
		
	}

	@Override
	@Transactional
	public Student getStudent(int theStudentId) {
		return studentDAO.getStudent(theStudentId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theStudentId) {
		studentDAO.deleteStudent(theStudentId);
		
	}

}

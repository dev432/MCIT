package com.jim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jim.dao.CourseDAO;
import com.jim.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		courseDAO.saveCourse(theCourse);
		
	}

	@Override
	@Transactional
	public Course getCourse(int theCourseId) {
		return courseDAO.getCourse(theCourseId);
	}

	@Override
	@Transactional
	public void deleteCourse(int theCourseId) {
		courseDAO.deleteCourse(theCourseId);
		
	}

}

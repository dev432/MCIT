package com.jim.dao;

import java.util.List;

import com.jim.entity.Course;


public interface CourseDAO {

	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(int theCourseId);

	public void deleteCourse(int theCourseId);
}

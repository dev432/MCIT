package com.jim.service;

import java.util.List;

import com.jim.entity.Course;

public interface CourseService {

	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(int theCourseId);

	public void deleteCourse(int theCourseId);
}

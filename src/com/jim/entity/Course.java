package com.jim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="courseid")
	private int courseId;

	@Column(name="coursename")
	private String courseName;

	@Column(name="creditnumber")
	private String creditNumber;
	

	public Course() {
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCreditNumber() {
		return creditNumber;
	}


	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", creditNumber=" + creditNumber + "]";
	}

	
	
	
	
	
	
	
}

package com.jim.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jim.entity.Course;


@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Course> getCourses() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Course> theQuery =  currentSession.createQuery("from Course", Course.class);
		
		List<Course> courses = theQuery.getResultList();
				
		return courses;
	}


	@Override
	public void saveCourse(Course theCourse) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCourse);
				
	}


	@Override
	public Course getCourse(int theCourseId) {
		
		// get the current hb session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from db 
		Course theCourse = currentSession.get(Course.class, theCourseId);
		
		return theCourse;
	}


	@Override
	public void deleteCourse(int theCourseId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =  currentSession.createQuery("delete from Course where courseId=:courseId");
		theQuery.setParameter("courseId", theCourseId);
		
		theQuery.executeUpdate();
	}

}

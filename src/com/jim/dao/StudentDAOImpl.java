package com.jim.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jim.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Student> getStudents() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Student> theQuery =  currentSession.createQuery("from Student", Student.class);
		
		List<Student> students = theQuery.getResultList();
				
		return students;
	}


	@Override
	public void saveStudent(Student theStudent) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStudent);
				
	}


	@Override
	public Student getStudent(int theStudentId) {
		
		// get the current hb session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from db 
		Student theStudent = currentSession.get(Student.class, theStudentId);
		
		return theStudent;
	}


	@Override
	public void deleteStudent(int theStudentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =  currentSession.createQuery("delete from Student where studentId=:studentId");
		theQuery.setParameter("studentId", theStudentId);
		
		theQuery.executeUpdate();
	}

}

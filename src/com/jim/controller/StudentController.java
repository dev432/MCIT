package com.jim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jim.dao.StudentDAO;
import com.jim.entity.Student;
import com.jim.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		List<Student> theStudents = studentService.getStudents();
		
		theModel.addAttribute("students", theStudents);
		
		return "list-students";
	}

	@GetMapping("/formForAdd")
	public String formForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
				
		return "student-form";
	}
	@PostMapping("/saveStudent")
	public String saveStudent (@ModelAttribute("student") Student theStudent) {
		
		// save student using service
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";
	}
	
	@GetMapping("/formForUpdate")
	public String formForUpdate(@RequestParam("studentId") int theStudentId, Model theModel) {
		
		//get student from DB
		Student theStudent = studentService.getStudent(theStudentId);
		
		//set student as a model
		theModel.addAttribute("student", theStudent);
		
		// form
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theStudentId) {
		
		// delete the customer
		studentService.deleteStudent(theStudentId);
		return "redirect:/student/list";
	}
}
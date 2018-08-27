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

import com.jim.dao.CourseDAO;
import com.jim.entity.Course;
import com.jim.service.CourseService;


@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {

		List<Course> theCourses = courseService.getCourses();
		
		theModel.addAttribute("courses", theCourses);
		
		return "list-courses";
	}

	@GetMapping("/formForAdd")
	public String formForAdd(Model theModel) {
		Course theCourse = new Course();
		theModel.addAttribute("course", theCourse);
				
		return "course-form";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse (@ModelAttribute("course") Course theCourse) {
		
		// save course using service
		courseService.saveCourse(theCourse);
		return "redirect:/course/list";
	}
	
	@GetMapping("/formForUpdate")
	public String formForUpdate(@RequestParam("courseId") int theCourseId, Model theModel) {
		
		//get course from DB
		Course theCourse = courseService.getCourse(theCourseId);
		
		//set course as a model
		theModel.addAttribute("course", theCourse);
		
		// form
		return "course-form";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam("courseId") int theCourseId) {
		
		// delete the customer
		courseService.deleteCourse(theCourseId);
		return "redirect:/course/list";
	}
	
	
	
}

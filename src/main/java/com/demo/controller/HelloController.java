package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;

@Controller
public class HelloController {
	
	@GetMapping("sayHello")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Keep learning to be competent!");
		return mav;
	}
	
	@GetMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("John");
		student.setScore(99);
		mav.addObject("student", student);
		return mav;
	}
	
	@GetMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("students");
		Student student = new Student();
		student.setName("John");
		student.setScore(99);
		Student student2 = new Student();
		student2.setName("Johny");
		student2.setScore(79);
		List<Student> students = Arrays.asList(student, student2);
		mav.addObject("students", students);
		return mav;
	}
	
	@GetMapping("/studentForm")
	public ModelAndView showStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("Bob");
		student.setScore(88);
		mav.addObject(student);
		return mav;
	}
	
	@GetMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getScore());
		mav.addObject(student);
		return mav;
	}
}

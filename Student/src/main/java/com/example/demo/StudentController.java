package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	
	@GetMapping("/showStudent")
	public ModelAndView students() {
		System.out.println("show student");
		List<Student> students =  studentService.getAllStudent();
		return new ModelAndView("showStudent","students",students);
	}

	@GetMapping("/showStudent/{email}")
	public ModelAndView students(@PathVariable("email") String email) {
		System.out.println("show student valid");
		return new ModelAndView("addStudent","student",studentService.getStudent(email));
	}

}

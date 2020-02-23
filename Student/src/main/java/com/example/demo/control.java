package com.example.demo;
	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@Controller
public class control {
	
	@Autowired
	private StudentService studentService;
	
//	@RequestMapping("/home")
//	public ModelAndView home(@RequestParam("name") String name) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",name);
//		mv.setViewName("home");
//		System.out.println("Controller");
//		return mv;
	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);
		System.out.println("rrrrrrrrrrrrr");
		return "home";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student",new Student());
		System.out.println("student");
		return "addStudent";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@Valid @ModelAttribute("student") Student student, Errors errors, BindingResult bindingResult, Model model) {
		if(errors.hasErrors()) {
			System.out.println("errors");
			return "addStudent";
		}else {
			
			if(studentService.isMail(student.getEmail())) {
				System.out.println("add");
				studentService.addStudent(student);	
			}else {
				System.out.println("update");
				studentService.updateStudent(student);
			}
			
			System.out.println("student valid");
			return "redirect:/showStudent";
		}
	}
	}


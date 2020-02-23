package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService {


	@Autowired
	private Dao dao;
	
	public int addStudent(Student student) {
		dao.addStudent(student);
		return 0;
	}

	public Student getStudent(String email) {
		return dao.getStudent(email);
	}

	public boolean updateStudent(Student student) {
		
		return dao.updateStudent(student);
	}

	public List<Student> getAllStudent() {
		
		return dao.getAllStudents();
	}

	public boolean isMail(String email) {
		return dao.isMail(email);
	}

}

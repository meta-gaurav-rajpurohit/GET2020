package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	static List<Student> students = new ArrayList<Student>();

	public int addStudent(Student student) {
		students.add(student);
		return 0;
	}

	public Student getStudent(String email) {

		Student student_ = null;

		for (Student student : students) {
			if (email.equals(student.getEmail())) {
				student_ = student;
				break;
			}
		}
		return student_;
	}

	public boolean updateStudent(Student student) {
		Student oldEmp = getStudent(student.getEmail());
		int index =  students.indexOf(oldEmp);
		students.remove(index);
		students.add(student); 
		return true;
	}

	public List<Student> getAllStudents() {

		return students;
	}

	public boolean isMail(String email) {
		for (Student student : students) {
			if (email.equals(student.getEmail())) {
				return false;
			}
		}
		return true;
	}

}


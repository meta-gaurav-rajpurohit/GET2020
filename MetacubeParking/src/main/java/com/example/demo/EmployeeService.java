package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {


	@Autowired
	private EmployeeDAO employeDAO;
	
	public int addEmployee(Employee employee) throws SQLException, IOException {
		return employeDAO.addEmployee(employee);
	}

	public Employee getEmployee(int empId) throws IOException, SQLException {
		return employeDAO.getEmployee(empId);
	}

	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {
		
		return employeDAO.updateEmployee(updateModel);
	}

	public int checkAuthentication(String emailID, String password) throws SQLException, IOException {
		return employeDAO.checkAuthentication(emailID, password);
	}
	
	public int checkEmailId(String emailID) throws SQLException, IOException {
		return employeDAO.checkEmailId(emailID);
	}

	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		return employeDAO.getEmployeeFriends(empId);
	}

	public void addVehicle(Vehicle vehicle) throws SQLException {
		employeDAO.addVehicle(vehicle);
	}

	public void addVehiclePrice(int empId, double price) throws SQLException {
		employeDAO.addVehiclePrice(empId, price);
	}

	public boolean changePassword(int empId, String newPassword, String oldPassword) throws SQLException {
		return employeDAO.changePassword(empId, newPassword, oldPassword);
	}

	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		employeDAO.setEmployeeImage(empId, imageName);
	}
	public String getEmployeeImage(int empId) throws SQLException {
		return employeDAO.getEmployeeImage(empId);
	}

//	public void setEmployeeImage(int empId, byte[] bytes) throws SQLException {
//		employeDAO.setEmployeeImage(empId, bytes);
//	}
//	public String getEmployeeImage(int empId) throws SQLException {
//		return employeDAO.getEmployeeImage(empId);
//	}

}

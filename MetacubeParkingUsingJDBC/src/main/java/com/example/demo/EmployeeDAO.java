package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //insert query
    private String SQL_INSERT_USER = "insert into Employee(empId,name, emailId,number, gender, password, Organization) values(empId,?,?,?,?,?,?)";
    private String SQL_INSERT_VEHICLE = "insert into vehicle(empId, vehicle_name, vehicle_type, vehicle_number, Identification, currency) values(?,?,?,?,?,?)";
    private String SQL_INSERT_PRICE = "insert into Price(empId, price) values(?,?)";
    private String SQL_INSERT_IMAGE = "insert into image values(?, ?)";

    //update query
    private String SQL_UPDATE_PASSWORD  = "update Employee set password = ? where empId = ?";
    private String SQL_UPDATE_EMPLOYEE = "update Employee set name = ?, emailId = ?, number = ?, organization = ? where empId = ?";
    private String SQL_UPDATE_IMAGE = "update image set imagename = ? where empId = ?";
    
    //get query
    private String SQL_GET_EMPID_IF_EMAIL_EXIST = "SELECT empId FROM Employee where emailId=?";
    private String SQL_GET_EMPLOYEE = "SELECT * FROM Employee where empId=?";
    private String SQL_GET_ORGANIZATION = "SELECT organization FROM Employee where empId=?";
    private String SQL_GET_FRIENDS = "SELECT * FROM Employee where organization=? order by name";
    private String SQl_GET_PASSWORD = "SELECT password FROM Employee where empId=?";
    private String SQL_GET_IMAGE = "SELECT imagename FROM image where empId=?";
    
    //check query
    private String SQl_CHECK_AUTHENTICATION = "SELECT empId FROM Employee where emailId=? && password = ?";
    private String SQL_CHECK_EMAILID_WITH_EMPID = "select empId from Employee where empId != ? && emailId = ?";
    private String SQL_CHECK_EMPID_IN_IMAGE = "select empId from image where empId = ?";
    
    
	public int addEmployee(Employee employee) throws SQLException, IOException {
		jdbcTemplate.update(SQL_INSERT_USER, employee.getName(), employee.getEmailID(),
				employee.getEmailID(), employee.getGender(), employee.getPassword(),
				employee.getOrganization());
		return checkEmailId(employee.getEmailID());
	}

	public Integer checkEmailId(String emailID) throws SQLException {
		try {
			int empId = jdbcTemplate.queryForObject(SQL_GET_EMPID_IF_EMAIL_EXIST, new Object[] { emailID }, Integer.class);
			return empId;
		}catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public void addVehicle(Vehicle vehicle) throws SQLException{
        jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicle.getEmpId(), vehicle.getVehicleName(),
        		vehicle.getVehicleType(), vehicle.getVehicleNumber(), vehicle.getIdentification(),
        		vehicle.getCurrency());
        
    }
	
	public void addVehiclePrice(int empId, double price) throws SQLException{
		jdbcTemplate.update(SQL_INSERT_PRICE, empId, price);
    }
	
	public Employee getEmployee(int empId) throws  IOException, SQLException{
			return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEE, new Object[] { empId }, new EmployeeMapper());
		
	}
	public int checkAuthentication(String email, String password) throws SQLException, IOException{
        try{
        int empId = jdbcTemplate.queryForObject(SQl_CHECK_AUTHENTICATION, new Object[] { email, password }, Integer.class);
        return empId;
        }catch(EmptyResultDataAccessException e) {
        	return 0;
        }
    }
	
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
        String organizarion = jdbcTemplate.queryForObject(SQL_GET_ORGANIZATION, new Object[] { empId }, String.class);
		return jdbcTemplate.query(SQL_GET_FRIENDS, new Object[] { organizarion }, new EmployeeMapper());
	}

	public boolean changePassword(int empId, String newPassword, String oldPassword) throws SQLException {
        String password = jdbcTemplate.queryForObject(SQl_GET_PASSWORD, new Object[] { empId }, String.class);
        
        if(oldPassword.equals(password)){
        	jdbcTemplate.update(SQL_UPDATE_PASSWORD, newPassword, empId);
            return true;
        }
        return false;
        
	}

	public boolean checkEmailWithEmapid(UpdateModel updateModel) {
		try {
			jdbcTemplate.queryForObject(SQL_CHECK_EMAILID_WITH_EMPID, new Object[] {updateModel.getEmpId(),updateModel.getEmailID()}, Integer.class);
			return true;
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
	}
	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {
		if(checkEmailWithEmapid(updateModel)){
			return false;
        }
        else {
            jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, updateModel.getName(), updateModel.getEmailID(),
            		updateModel.getNumber(), updateModel.getOrganization(), updateModel.getEmpId());
            return true;
        }
	}

	public boolean checkEmpidInImage(int empId) {
		try {
			jdbcTemplate.queryForObject(SQL_CHECK_EMPID_IN_IMAGE, new Object[] {empId}, Integer.class);
			return true;
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
	}
	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		if(!checkEmpidInImage(empId))
	        jdbcTemplate.update(SQL_INSERT_IMAGE, empId, imageName);
		else 
		    jdbcTemplate.update(SQL_UPDATE_IMAGE, imageName, empId);
	}
	
	
	public String getEmployeeImage(int empId) throws SQLException {
		try {
			String imageName = jdbcTemplate.queryForObject(SQL_GET_IMAGE, new Object[] {empId}, String.class);
			return imageName;
		}catch(EmptyResultDataAccessException e) {
			return "Avatar.jpg";
		}
	}
}
package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/java_tutorials";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private ResultSet friendsList = null;
    
    public void connection(){
        try {
        	System.out.println("connection");
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }

	public int addEmployee(Employee employee) throws SQLException, IOException {
		PreparedStatement ps = con
                .prepareStatement("insert into Employee(empId,name, emailId,number, gender, password, Organization) values(empId,?,?,?,?,?,?)");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getEmailID());
        ps.setString(3, employee.getNumber());
        ps.setString(4, employee.getGender());
        ps.setString(5, employee.getPassword());
        ps.setString(6, employee.getOrganization());
        ps.executeUpdate();
        return checkEmailId(employee.getEmailID());
	}

	public int checkEmailId(String emailID) throws SQLException {
		connection();
			stm = null;
			int empId = 0;
			
	        stm = (Statement) con.createStatement();
	        String strQuery = "SELECT empId FROM Employee where emailId='"+emailID+"'";
	        rs = stm.executeQuery(strQuery);
	        while(rs.next()) {
	        	empId = (int)rs.getLong("empId");
	        	return empId;
	        }
	        return empId;
	}

	public void addVehicle(Vehicle vehicle) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into vehicle(empId, vehicle_name, vehicle_type, vehicle_number, Identification, currency) values(?,?,?,?,?,?)");
        ps.setLong(1, vehicle.getEmpId());
        ps.setString(2, vehicle.getVehicleName());
        ps.setString(3, vehicle.getVehicleType());
        ps.setString(4, vehicle.getVehicleNumber());
        ps.setString(5, vehicle.getIdentification());
        ps.setString(6, vehicle.getCurrency());
        ps.executeUpdate();
        
    }
	
	public void addVehiclePrice(int empId, double price) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into Price(empId, price) values(?,?)");
        ps.setLong(1, empId);
        ps.setDouble(2, price);
        ps.executeUpdate();
    }
	
	public Employee getEmployee(int empId) throws  IOException, SQLException{
		connection();
		Employee employee = new Employee();
			stm = null;
	        stm = (Statement) con.createStatement();
	        String strQuery = "SELECT * FROM Employee where empId="+empId;
	        rs = stm.executeQuery(strQuery);
	        rs.next();
	        employee.setEmpId(Integer.parseInt(rs.getString("empId")));
	        employee.setName(rs.getString("name"));
	        employee.setEmailID(rs.getString("emailId"));
	        employee.setGender(rs.getString("gender"));
	        employee.setNumber(rs.getString("number"));
	        employee.setOrganization(rs.getString("organization"));
	        
			return employee;
		
	}
	public int checkAuthentication(String email, String password) throws SQLException, IOException{
		connection();
        stm = null; 
        int empId = 0;
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT empId FROM Employee where emailId='"
                + email + "' && password = '"+password+"'";
        rs = stm.executeQuery(strQuery);
        while (rs.next()) { 
        	empId = Integer.parseInt(rs.getString("empId"));
        	return empId; 
        }
        return empId;
    }
	
	public List<Employee> getEmployeeFriends(int empId) throws SQLException {
		connection();
		stm = null;        
        stm = (Statement) con.createStatement();
        List<Employee> employees = new ArrayList<Employee>();
        
        String strQuery = "SELECT organization FROM Employee where empId="+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        String friendListQuery = "SELECT * FROM Employee where organization='"
                + rs.getString("organization")+"'  order by name";
        friendsList = stm.executeQuery(friendListQuery);
        
        while(friendsList.next()) {
        	Employee employee = new Employee();
        	employee.setEmpId((int)friendsList.getLong("empId"));
	        employee.setName(friendsList.getString("name"));
	        employee.setEmailID(friendsList.getString("emailId"));
	        employee.setGender(friendsList.getString("gender"));
	        employee.setNumber(friendsList.getString("number"));
	        employee.setOrganization(friendsList.getString("organization"));
	        employees.add(employee);
        }
        return employees;
	}

	public boolean changePassword(int empId, String newPassword, String oldPassword) throws SQLException {
		connection();
		stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT password FROM Employee where empId="
                + empId;
        String updateQuery = "update Employee set password = '"+newPassword+"' where empId = "+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        if(oldPassword.equals(rs.getString("password"))){
            stm.execute(updateQuery);
            return true;
        }
        return false;
	}
	
	public void close() throws SQLException{
        con.close();
    }

	public boolean updateEmployee(UpdateModel updateModel) throws SQLException {
		
		String checkQuery = "select emailId from Employee where empId != "+updateModel.getEmpId()+" && "
				+ "emailId = '"+updateModel.getEmailID()+"'";
		rs = stm.executeQuery(checkQuery);
		System.out.println(checkQuery);
		if(rs.next()){
            return false;
        }
        else {
            String Query = "update Employee set name = '"+updateModel.getName()+"', "
                            + "emailId = '"+updateModel.getEmailID()+"', "
                                    + "number = '"+updateModel.getNumber()+"' , "
                                            + "organization = '"+updateModel.getOrganization()+"' where empId = "+updateModel.getEmpId();
            System.out.println(Query);
            stm.execute(Query);
            return true;
            
        }
	}

	public void setEmployeeImage(int empId, String imageName) throws SQLException {
		connection();
		stm = null;
				
		stm = (Statement) con.createStatement();
		String checkQuery = "select empId from image where empId = "+empId;
		rs = stm.executeQuery(checkQuery);
		if(!rs.next()) {
			PreparedStatement insert = con
                .prepareStatement("insert into image values(?, ?)");
	        insert.setLong(1, empId);
	        insert.setString(2, imageName);
	        insert.executeUpdate();
		}
		else {
			PreparedStatement insert = con
	                .prepareStatement("update image set imagename = ? where empId = "+empId);
		    insert.setString(1, imageName);
		    insert.executeUpdate();
		}
    
	}
	
	public String getEmployeeImage(int empId) throws SQLException {
		connection();
		stm = null;
		String imageName = "Avatar.jpg";
				
		stm = (Statement) con.createStatement();
		String strQuery = "SELECT imagename FROM image where empId="+empId;
		rs = stm.executeQuery(strQuery);
		while(rs.next()) {
		   	imageName = rs.getString("imagename");
		}
		return imageName;
	}

//	public void setEmployeeImage(int empId, byte[] bytes) throws SQLException {
//		connection();
//		stm = null;
//				
//		stm = (Statement) con.createStatement();
//			PreparedStatement insert = con
//                .prepareStatement("insert into EmployeeImage values(?, ?)");
//	        insert.setLong(1, empId);
//	        insert.setBytes(2, bytes);
//	        insert.executeUpdate();
//		
//
//	}
	
//	public byte[] getEmployeeImage(int empId ) throws SQLException, IOException {
//		connection();
//		stm = null;
//		Blob image = null;
//		byte imageName[] = null;
//				
//		stm = (Statement) con.createStatement();
//		String strQuery = "SELECT image FROM EmployeeImage where empId="+empId;
//		rs = stm.executeQuery(strQuery);
//		if(rs.next()) {
//			image = (Blob) rs.getBlob(1);
//			imageName = image.getBytes(1,(int)image.length());
//		}
//		response.setContentType("image/jpg");
//		OutputStream o = response.getOutputStream();
//		o.write(imageName);
//		o.flush();
//		o.close();
//		while(rs.next()) {
//			System.out.println(rs.getBytes("image")+" grv");
//			System.out.println(rs.getBytes("image")+" grrrv");
//		   	imageName = rs.getBytes("image");
//		}
//		return imageName;
//	}

}


package system;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;

public class DatabaseConnectivity {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/java_tutorials";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private static DatabaseConnectivity DC = new DatabaseConnectivity();
    
    
    private DatabaseConnectivity(){}
    
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    public static DatabaseConnectivity getInstance(){
        return DC;
    }

    public int setDataEmployee(Employee employee) throws SQLException, IOException{
        PreparedStatement ps = con
                .prepareStatement("insert into Employee(empId,name, emailId,number, gender, password, Organization) values(empId,?,?,?,?,?,?)");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getEmailID());
        ps.setString(3, employee.getNumber());
        ps.setString(4, employee.getGender());
        ps.setString(5, employee.getPassword());
        ps.setString(6, employee.getOrganization());
        ps.executeUpdate();
        return searchEmail(employee.getEmailID(), employee.getPassword());
        
    }
    
    public void setDataVehicle(Vehicle vehicle) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into vehicle(empId, vehicle_name, vehicle_type, vehicle_number, Identification, currency) values(?,?,?,?,?,?)");
        ps.setLong(1, vehicle.getEmpId());
        ps.setString(2, vehicle.getVahicleName());
        ps.setString(3, vehicle.getVahicleType());
        ps.setString(4, vehicle.getVahicleNumber());
        ps.setString(5, vehicle.getIdentification());
        ps.setString(6, vehicle.getCurrency());
        ps.executeUpdate();
        
    }
    
    public int searchEmail(String email, String password) throws SQLException, IOException{
        int employeeAlreadyExist = 0;
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT empId FROM Employee where emailId='"
                + email + "' && password = '"+password+"'";
        rs = stm.executeQuery(strQuery);
        
        while (rs.next()) {
            employeeAlreadyExist = rs.getInt("empId");
        }
        return employeeAlreadyExist;
    }
    
    public void setDataPrice(int id, double price) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("insert into Price(empId, price) values(?,?)");
        ps.setLong(1, id);
        ps.setDouble(2, price);
        ps.executeUpdate();
   //     stm.close();
        
    }
    
    public ResultSet searchData(int empId) throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM Employee where empId="+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        return rs;
    }
    
    public int searchEmailId(String email) throws SQLException, IOException{
        int employeeAlreadyExist = 0;
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT empId FROM Employee where emailId='"
                + email + "'";
        rs = stm.executeQuery(strQuery);
        
        while (rs.next()) {
            employeeAlreadyExist = rs.getInt("empId");
        }
        return employeeAlreadyExist;
    }
    
    public boolean updateEmployee(Employee employee, int empId) throws SQLException, IOException{
        if(searchEmailId(employee.getEmailID()) != empId){
            return false;
        }
        else {
            String Query = "update Employee set name = '"+employee.getName()+"', "
                            + "emailId = '"+employee.getEmailID()+"', "
                                    + "number = '"+employee.getNumber()+"' , "
                                            + "organization = '"+employee.getOrganization()+"' where empId = "+empId;
            System.out.println(Query);
            stm.execute(Query);
            return true;
            
        }
    }
    
    public boolean changePassword(int empId, String oldpassword, String newpassword) throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT password FROM Employee where empId="
                + empId;
        String updateQuery = "update Employee set password = '"+newpassword+"' where empId = "+empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        if(oldpassword.equals(rs.getString("password"))){
            stm.execute(updateQuery);
            return true;
        }
            
        return false;
    }
    public ResultSet friendsList(int empId) throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT organization FROM Employee where empId="
                + empId;
        rs = stm.executeQuery(strQuery);
        rs.next();
        String friendListQuery = "SELECT name, organization, emailId FROM Employee where organization='"
                + rs.getString("organization")+"'  order by name";
        return stm.executeQuery(friendListQuery);
    }
    
    public ResultSet userInformation(int empId) throws SQLException{
        stm = null;
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT name, emailId, organization, number, gender FROM Employee where empId="
                + empId;
        return stm.executeQuery(strQuery);
    }
    public void close() throws SQLException{
        con.close();
    }
}

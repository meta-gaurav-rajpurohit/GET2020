package student;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/student_detail";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private static Database DC = new Database();
    
    
    private Database(){}
    
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    public static Database getInstance(){
        return DC;
    }

    public boolean setDataStudent(Student student) throws SQLException, IOException{
        if(searchEmail(student.getGmail()) > 0){
            return false;
        }
        else {
            PreparedStatement ps = con
                    .prepareStatement("insert into Student(stdId, first_name, last_name, father_name, emailId, age, class) values(stdId,?,?,?,?,?,?)");
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getFatherName());
            System.out.println("000000000000000000000000000000000");
            ps.setString(4, student.getGmail());
            System.out.println("000000000000000000000000000000000");
            ps.setLong(5, student.getAge());
            System.out.println("000000000000000000000000000000000");
            ps.setString(6, student.getCls());
            ps.executeUpdate();
            System.out.println("000000000000000000000000000000000");
            return true;
        }
    }
    
    public int searchEmail(String email) throws SQLException, IOException{
        int employeeAlreadyExist = 0;
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT stdId FROM Student where emailId='"
                + email + "'";
        rs = stm.executeQuery(strQuery);
        System.out.println(rs);
        
        while (rs.next()) {
            employeeAlreadyExist = rs.getInt("stdId");
            System.out.println(rs.getInt("stdId"));
        }
        return employeeAlreadyExist;
    }
    
    public ResultSet searchStudent(String FirstName, String LastName) throws SQLException, IOException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM Student where first_name = '"
                +FirstName+ "' && last_name = '"+LastName+"'";
        rs = stm.executeQuery(strQuery);
        System.out.println(rs);
        
        return rs;
    }
    
    public ResultSet searchAllStudent() throws SQLException, IOException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM Student";
        rs = stm.executeQuery(strQuery);
        System.out.println(rs);
        
        return rs;
    }
    
    public boolean updateDataStudent(Student student, int stdId) throws SQLException, IOException{
        System.out.println("Error : "+searchEmail(student.getGmail()));
        if(searchEmail(student.getGmail()) != stdId){
            System.out.println("Error : "+stdId);
            System.out.println("Error : "+searchEmail(student.getGmail()));
            return false;
        }
        else {
            String Query = "update Student set first_name = '"+student.getFirstName()+"', "
                            + "last_name = '"+student.getLastName()+"', "
                                    + "father_name = '"+student.getFatherName()+"' , "
                                            + "emailId = '"+student.getGmail()+"', "
                                                    + "age = "+student.getAge()+", "
                                                            + "class = '"+student.getCls()+"' where stdId = "+stdId;
            System.out.println(Query);
            stm.execute(Query);
            return true;
            
        }
    }
    public void close() throws SQLException{
        con.close();
    }
}

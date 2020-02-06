package system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 */
//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        int empId ;
        
        String name = (request.getParameter("Name"));
        String email = (request.getParameter("email"));
        String password = (request.getParameter("Password"));
        String confirmPassword = (request.getParameter("ConfirmPassword"));
        String number = (request.getParameter("number"));
        String gender = (request.getParameter("Gender"));
        String organization = (request.getParameter("Organization"));

        Employee employee = new Employee();

        employee.setName(name);
        employee.setEmailID(email);
        employee.setPassword(password);
        employee.setNumber(number);
        employee.setGender(gender);
        employee.setOrganization(organization);

        DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
        dc.connection();
        
        try {
            empId = dc.setDataEmployee(employee);
            dc.close();
            HttpSession session = request.getSession();
            session.setAttribute("empId", empId);
            response.sendRedirect("Home.jsp");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

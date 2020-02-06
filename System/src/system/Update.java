package system;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
//@WebServlet("/Update")
public class Update extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = (request.getParameter("Name"));
	        String email = (request.getParameter("email"));
	        String number = (request.getParameter("number"));
	        String organization = (request.getParameter("Organization"));
	        
	        Employee employee = new Employee();

	        employee.setName(name);
	        employee.setEmailID(email);
	        employee.setNumber(number);
	        employee.setOrganization(organization);

	        DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
	        dc.connection();
	        HttpSession session = request.getSession();
	        int empId = (int) session.getAttribute("empId");
	        try {
	            if(dc.updateEmployee(employee, empId)){
	                dc.close();
	                response.sendRedirect("Home.jsp");
	            }
	            else{
	                dc.close();
	                response.sendRedirect("Update.jsp");
	            }
	        } catch (SQLException e) {
	            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	            e.printStackTrace();
	        }
	}

}

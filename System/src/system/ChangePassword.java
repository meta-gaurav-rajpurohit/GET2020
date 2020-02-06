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
 * Servlet implementation class ChangePassword
 */
//@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String oldpassword = (request.getParameter("OldPassword"));
	        String newpassword = (request.getParameter("NewPassword"));
	        
	        DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
	        dc.connection();
	        HttpSession session = request.getSession();
                int empId = (int) session.getAttribute("empId");
	        
	        try {
	            if(dc.changePassword(empId, oldpassword, newpassword)){
	                dc.close();
	                response.sendRedirect("Home.jsp");
	            }
	            else{
	                dc.close();
	                response.sendRedirect("changePassword.html");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}

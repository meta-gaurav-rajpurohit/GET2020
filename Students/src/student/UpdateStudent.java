package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateStudent
 */
//@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String FirstName = request.getParameter("FirstName");
	        String LastName = request.getParameter("LastName");
	        String FatherName = request.getParameter("FatherName");
	        String Gmail = request.getParameter("email");
	        int Age = Integer.parseInt(request.getParameter("Age"));
	        String Class = request.getParameter("Class");

	        Student student = new Student();

	        student.setFirstName(FirstName);
	        student.setLastName(LastName);
	        student.setFatherName(FatherName);
	        student.setGmail(Gmail);
	        student.setAge(Age);
	        student.setCls(Class);

	        
	        HttpSession session = request.getSession();
	        System.out.println("vvvvvvkkkkkkkkkkkkkkkkkkkkkkkkkkkkkvv");
	        int id = (int) session.getAttribute(Gmail);
	        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	        
	        PrintWriter out = response.getWriter();
	        Database dc = Database.getInstance();
	        dc.connection();
	        try {
	            if(!dc.updateDataStudent(student, id)){
	                dc.close();
	                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	                out.println("<script>$(document).ready(function(){swal('Email ID Already Registered','Unsuccessfull !', 'error')});</script>");
	                RequestDispatcher rd = request.getRequestDispatcher("Update.html");
	                rd.include(request,response);
	            }
	            else{
	                dc.close();
	            }
	            out.println("<a href = 'Index.html'><input type = 'button' value = 'Home' ></a>");
	        } catch (SQLException e) {
	            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	            e.printStackTrace();
	        }
	}

}

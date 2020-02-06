package system;

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String email = (request.getParameter("email"));
        String password = (request.getParameter("Password"));
        
        PrintWriter out = response.getWriter();
        
        DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
        dc.connection();
        
        HttpSession session = request.getSession();
        
        
        try {
            int id = dc.searchEmail(email, password);
            session.setAttribute("empId", id);
            if(id > 0){
                session.setAttribute("emailId", email);
                response.sendRedirect("Home.jsp");
            }
            else{
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>$(document).ready(function(){swal('Email ID Not Valid','Unsuccessfull !', 'error')});</script>");
                RequestDispatcher rd = request.getRequestDispatcher("loggin.html");
                rd.include(request,response);
            }
            dc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

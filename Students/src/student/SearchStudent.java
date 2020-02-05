package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
//@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        
        PrintWriter out = response.getWriter();
        Database dc = Database.getInstance();
        dc.connection();
        try {
            ResultSet rs = dc.searchStudent(FirstName, LastName);
            out.println("<table><tr>"
                    + "<th>id</th> <th>fiest name</th> <th>last name</th> <th>father name</th> <th>age</th> <th>email id</th> <th>class</th>"
                    + "</tr>");
            while(rs.next()){
                out.println("<tr>"
                        + "<td>"+rs.getInt("stdId")+"</td> <td>"+rs.getString("first_name")+"</td> <td>"+rs.getString("last_name")+"</td> "
                                + "<td>"+rs.getString("father_name")+"</td> <td>"+rs.getString("age")+"</td> <td>"+rs.getString("emailId")+"</td> <td>"+rs.getString("class")+"</td>"
                        + "</tr>");
            }
            out.println("</table>");
            dc.close();
            out.println("<a href = 'Index.html'><input type = 'button' value = 'Home' ></a>");
        } catch (SQLException e) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
        }
    }

}

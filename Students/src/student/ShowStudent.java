package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowStudent
 */
//@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Database dc = Database.getInstance();
        dc.connection();
        try {
            ResultSet rs = dc.searchAllStudent();
            out.println("<script src='UpdateByJavaScript.js'></script>");
            out.println("<table><tr>"
                    + "<th>fiest name</th> <th>last name</th> <th colomspan = 2>email id</th>"
                    + "</tr>");
            
            while (rs.next()) {
                
                out.println("<tr>" + "<td>" + rs.getString("first_name")
                        + "</td> <td>" + rs.getString("last_name") + "<td id = 'mail'>"
                        + rs.getString("emailId") + "</td> <td><a href = 'Update.html?mail="+rs.getString("emailId")+"'>"
                                + "Update</a></td></tr> ");
                System.out.println(rs.getString("emailId"));
                session.setAttribute(rs.getString("emailId"), rs.getInt("stdId"));
            }
            out.println("</table>");
            out.println("<a href = 'Index.html'><input type = 'button' value = 'Home' ></a>");
            
            
            dc.close();
            
        } catch (SQLException e) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
        }
    }
}

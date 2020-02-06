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
 * Servlet implementation class GerPass
 */
//@WebServlet("/GerPass")
public class GerPass extends HttpServlet {
    public GerPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double price = Double.parseDouble(request.getParameter("price")) ;
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("empId");
		String currency = (String) session.getAttribute("currency");
		double USD = (double) session.getAttribute("USD");
		
		if("IND".equals(currency)){
	            price = price * USD;
	        }
	        else if("YEN".equals(currency)){
	            price = price * 0.0091;
	        }
		DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
	        dc.connection();
	        try {
	            dc.setDataPrice(id, price);
	            dc.close();
	            response.sendRedirect("Home.jsp");
//	            RequestDispatcher rd = request.getRequestDispatcher("getpass.html?currency="+currency+"&&vehicleType="+type);
//	            rd.include(request,response);
	 //       response.sendRedirect("getpass.html?heading="+heading+"&&daily="+Daily+"&&monthly="+Monthly+"&&yearly="+Yearly);
	       } catch (SQLException e) {
	            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	            e.printStackTrace();
	        }
		
	}

}

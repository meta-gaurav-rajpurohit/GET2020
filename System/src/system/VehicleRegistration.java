package system;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VehicleRegistration
 */
//@WebServlet("/VehicleRegistration")
public class VehicleRegistration extends HttpServlet {
    public VehicleRegistration() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        double Daily = 0, Monthly = 0, Yearly = 0;
        double USD = 0.013, YEN = 1.54 ;
        String heading = null;
        
        String name = (request.getParameter("VehicleName"));
        String type = (request.getParameter("VehicleType"));
        String number = (request.getParameter("VehicleNumber"));
//        int empid = Integer.parseInt((request.getParameter("empId")));
        String identification = (request.getParameter("Identification"));
        String currency = (request.getParameter("VehicleCurrency"));
        
        Vehicle vehicle = new Vehicle();

        vehicle.setVahicleName(name);
        vehicle.setVahicleType(type);
        vehicle.setVahicleNumber(number);
        
        HttpSession session = request.getSession();
        session.setAttribute("currency", currency);
        session.setAttribute("USD", USD);
        
        if("Cycle".equals(type)){
            heading = "CyclePass";
            Daily = 5;
            Monthly = 100;
            Yearly = 500;
        }
        else if("MotorCycle".equals(type)){
            heading = "MotorCycle Pass";
            Daily = 10;
            Monthly = 200;
            Yearly = 1000;
        }
        else if("Four Wheelers".equals(type)){
            heading = "Four Wheelers Pass";
            Daily = 20;
            Monthly = 500;
            Yearly = 3500;
        }
        if("INR".equals(currency)){
            Daily = Daily ;
            Monthly = Monthly ;
            Yearly = Yearly;
        }
        else if("USD".equals(currency)){
            Daily = Daily * USD;
            Monthly = Monthly * USD ;
            Yearly = Yearly * USD;
        }
        else if("YEN".equals(currency)){
            Daily = Daily * YEN;
            Monthly = Monthly * YEN;
            Yearly = Yearly * YEN;
        }
        
        System.out.println("vvvvvvkkkkkkkkkkkkkkkkkkkkkkkkkkkkkvv");
        vehicle.setEmpId((int) session.getAttribute("empId"));
        vehicle.setIdentification(identification);
        vehicle.setCurrency(currency);
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

        DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
        dc.connection();
        try {
            dc.setDataVehicle(vehicle);
            dc.close();
//            RequestDispatcher rd = request.getRequestDispatcher("getpass.html?currency="+currency+"&&vehicleType="+type);
//            rd.include(request,response);
        response.sendRedirect("getpass.html?heading="+heading+"&&daily="+Daily+"&&monthly="+Monthly+"&&yearly="+Yearly);
       } catch (SQLException e) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
        }
//        
    }

}

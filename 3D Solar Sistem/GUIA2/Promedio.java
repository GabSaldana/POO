import java.servlet.*;
import java.servlet.htttp.*;
import java.io.*;
public class Promedio{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException.IOException{

		PrintWriter out= res.getWriter();
		res.setContentType("text plain");
		double cf= Double.parseDouble)(res.getParameter("fisica"));
		double cm=Double.parseDouble(res.getParameter("mate"));
		double cq=Double.parseDouble(res.getParameter("quimic"));
		double ce=Double.parseDouble(res.getParameter("espa"));
		out.println("Tu promedio es:" + (cf+cm+cq+ce)/4);
	}
}
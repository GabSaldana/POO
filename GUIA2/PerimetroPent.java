import java.servlet.*;
import java.servlet.htttp.*;
import java.io.*;
public class PerimetroPent{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException.IOException{

		PrintWriter out= res.getWriter();
		res.setContentType("text plain");
		double l1= Double.parseDouble)(res.getParameter("l1"));
		double l2=Double.parseDouble(res.getParameter("l2"));
		double l3=Double.parseDouble(res.getParameter("l3"));
		double l4=Double.parseDouble(res.getParameter("l4"));
		double l5=Double.parseDouble(res.getParameter("l5"));
		out.println("perimetro =" + (l1+l2+l3+l4+l5));
	}
}
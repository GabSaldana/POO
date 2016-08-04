import java.servlet.*;
import java.servlet.http.*;
import java.io.*;

public class Circulo extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException.IOException{

		PrinterWriter out=res.getWriter();//flujo de salida que se obtiene de la respuesta
		res.setContentType("text plain");//tipo de dato a enviar
		double radio= Double.parseDouble(res.getParameter("radio"));//lo que obtiene son cadenas,hay que castear
		out.println("area: " + Math.PI * Math.pow(radio,2));//imprimimos en el flujo
	}
}

import java.awt.*;
import java.io*;//flujos
import java.net.*;//sockets
import java.util.*;//arrays

public class Server {
	Socket cli;
	ServerSocket serv;
	PrintStream salida;
	static final int puerto=5000;
	public Server(){
		try{

			serv=new ServerSocket(puerto);
			cli = serv.accept();
			salida= new PrintStream( cli.getOutputStream());
			salida.println("HOLA MUNDO");
			cli.close();
		} catch(Exception e){System.out.println( e.getMessage() ); }
	}
	public static void main(String [ ] args){new Server();	}
}

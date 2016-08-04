import java.awt.*;
import java.io*;//flujos
import java.net.*;//sockets
import java.util.*;//arrays

public class Ultimo{

	Socket cli;
	ServerSocket serv;
	ArrayList<String> visitas= new ArrayList<String>();
	PrintStream salida;//Salida
	static final int puerto=5000;
	DataInputStream entrada;//lectura

		try{
			while(true){
		 		serv= new ServerSocket(puerto);
		 		cli=serv.accept();
		 		entrada=new DataInputStream(cli.getInputStream());
		 		String name=entrada.readLine();
		 		visitas.add(name);
		 		salida=new PrintStream(cli.getOutputStream());
		 		salida.println(visitas.get(visitas.size()));//enviamos el ultimo en entrar
		 		cli.close();
		 	}
		} catch(Exception e){ }
	
}
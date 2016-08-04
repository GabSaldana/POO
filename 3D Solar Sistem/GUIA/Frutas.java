import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Frutas extends Applet implements ActionListener{

	Button frutas[];
	Label l1;
	String fru[]={"Manzana","Limon","Naranja"};
	public void init(){

		frutas=new Button[3];
		l1=new Label();
		for (int i=0;i<frutas.length;i++) {
			add( frutas[i]=new Button(fru[i]) );
			frutas[i].addActionListener(this);
		}
		add(l1);

	}
	public void actionPerformed(ActionEvent e){

		Button aux=(Button) e.getSource();
		if (aux==frutas[0]) {
			l1.setText(frutas[0] + " ");
		}
		if (aux==frutas[1]) {
			l1.setText(frutas[1] + " ");
		}
		if (aux==frutas[1]) {
			l1.setText(frutas[1] + " ");
		}

	}

}
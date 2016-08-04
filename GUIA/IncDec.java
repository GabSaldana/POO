import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class IncDec extends Applet implements ActionListener{

	Button b1,b2;
	Label l1;
	int cont=0;
	public void init(){

		b1=new Button("Incrementa");
		b2=new Button("Decrementa");
		l1=new Label();
		add(b1);add(b2);add(l1);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		Button aux=(Button) e.getSource();
		if (aux==b1) {
			l1.setText((cont++) + " ");
		}
		else{
			l1.setText((cont--) + " ");
		}
	}
}
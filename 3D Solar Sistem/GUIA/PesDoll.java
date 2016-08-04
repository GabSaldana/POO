import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class PesDoll extends Applet implements ActionListener{
		
		Button b1,b2;
		TextField t1;
		Label l1;
		public void init(){

			b1=new Button("Pesos a Dolares");
			b2=new Button("Dolares a Pesos");
			t1=new TextField(15);
			l1=new Label();
			add(b1);add(b2);add(t1);add(l1);
			b1.addActionListener(this);
			b2.addActionListener(this);
		    
		}

		public void actionPerformed (ActionEvent e){

			Button aux=(Button) e.getSource();

			if (aux==b1) {

				l1.setText(":" + (Double.parseDouble(t1.getText()) / 13.24) + "dolares");
			}
			if (aux==b2) {
				l1.setText(":" + (Double.parseDouble(t1.getText()) * 13.24) + "pesos");
				
			}

		}
}
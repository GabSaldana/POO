import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class MayordeTres extends Applet implements ActionListener{

	TextField t1,t2,t3;
	Button b1;
	Label l1;
	public void init(){

		t1=new TextField(10);
		t2=new TextField(10);
		t3=new TextField(10);
		b1=new Button("Obtener");
		l1=new Label();	
		add(t1);add(t2);add(t3);add(b1);add(l1);
		b1.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e){

		//Button aux=(Button) e.getSource;

		if( Double.parseDouble(t1.getText())> Double.parseDouble(t2.getText())  &&  
			Double.parseDouble(t1.getText())>Double.parseDouble(t3.getText()) ){
				
				l1.setText(t1.getText());
		}	
		if( Double.parseDouble(t2.getText())>Double.parseDouble(t1.getText())  && 
		 Double.parseDouble(t2.getText())>Double.parseDouble(t3.getText()) ){
			
			l1.setText(t2.getText());
		}
		if( Double.parseDouble(t3.getText())>Double.parseDouble(t1.getText())  && 
		 Double.parseDouble(t3.getText())>Double.parseDouble(t2.getText()) ){
			
			l1.setText(t3.getText());
		}

	}

}
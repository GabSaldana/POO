import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Conc extends Applet implements ActionListener{

	Button b1;
	TextField t1,t2;
	Label l1;
	public void init(){

		b1=new Button("Une");
		t1=new TextField(15);
		t2=new TextField(15);
		l1=new Label();
		add(b1);add(t1);add(t2);add(l1);
		b1.addActionListener(this); 
	}

	public void actionPerformed (ActionEvent e){

		l1.setText(t1.getText() + t2.getText() );

	}

}
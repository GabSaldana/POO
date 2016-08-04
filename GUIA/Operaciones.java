import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class Operaciones extends Applet implements ActionListener{

	JButton botones[];
	TextField t1,t2;
	Label l1;
	String signos[]={"+","-","*","/"};
	public void init(){

		t1=new TextField(20);
		t2=new TextField(20);
		l1=new Label("=");	
		botones=new JButton [4];
		//setLayout(new GridLayout(2,2));
		for (int i=0;i<botones.length;i++) {
			add( botones[i]=new JButton(signos[i]) );
			botones[i].addActionListener(this);
		}
		add(t1);add(t2);add(l1);

	}
	public void actionPerformed(ActionEvent e){

		JButton aux=(JButton) e.getSource();
		 if(aux==botones[0])
			l1.setText( (Double.parseDouble(t1.getText()) + (Double.parseDouble(t2.getText()))) + " " );
		if(aux==botones[1])
			l1.setText( (Double.parseDouble(t1.getText()) - (Double.parseDouble(t2.getText()))) + " " );
		if(aux==botones[2])
			l1.setText( (Double.parseDouble(t1.getText()) * (Double.parseDouble(t2.getText()))) + " ");
		if(aux==botones[3])
			l1.setText( (Double.parseDouble(t1.getText()) / (Double.parseDouble(t2.getText()))) + " " );

	}

}


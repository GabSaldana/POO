import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class MayorEdad extends JFrame implements ActionListener{

	Button b1;
	TextField t1;
	Label l1;
	public void init (){

		b1=new Button("Estatus");
		t1=new TextField(30);
		l1= new Label();
		add(b1);add(t1);add(l1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){

		if ((Double.parseDouble(t1.getText())>=18)) {
			l1.setText("Mayor de edad");
		}
		else
		{
			l1.setText("Menor de edad");
		}	
	}
}
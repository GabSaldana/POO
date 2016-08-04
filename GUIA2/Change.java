import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Change extends JFrame implements Runnable, ActionListener{
	JLabel l1;
	ArrayList<String> textos= new ArrayList<String>();
	JButton btn1;
	JTextField txt1;
	Thread hilo;
	int i=0;
	public Change(){
		
		l1= new JLabel("Cadena Actual:");
		btn1= new JButton("guardar");
		txt1=new JTextField();
		hilo=new Thread(this);
		l1.setBounds(300,100,100,50);	
		btn1.setBounds(200,100,100,50);	
		txt1.setBounds(100,100,100,50);	
		add(l1);add(txt1);add(btn1);
		btn1.addActionListener(this);
		txt1.addActionListener(this);
		setSize(500,500);
		setLayout(null);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e){
		if(btn1==e.getSource()){
		   textos.add(txt1.getText());
		}	
	}
	public void run(){
		try{

		  Iterator<String> it= textos.iterator();
			while(it.hasNext()){
				String elemento = it.next();
				hilo.sleep(1000);
				l1.setText(elemento);
			}
	    } catch(Exception e){ }
    }
public static void main(String [ ] args){new Change();	}

}

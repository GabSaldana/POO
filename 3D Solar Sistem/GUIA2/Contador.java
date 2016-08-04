import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Contador extends JFrame implements Runnable{
	int cont=50;
	JLabel l1;
	Thread hilo;
	int i=0;
	public Contador(){
		l1=new JLabel();
		l1.setBounds(100,100,100,50);	
		l1.setText(":");
		add(l1);
		setLayout(null);
	    setSize(500,500);
	    setVisible(true);
		hilo=new Thread(this);
		hilo.start();
	}
	public void run(){
		try{
		while(i<=cont){
				hilo.sleep(1000);//tiempo de intervalo entre cada incremento de i
				l1.setText(String.valueOf(i));
				i++;
			}
		}catch (Exception e){ System.out.println("error");}
	}
 public static void main(String [ ] args){new Contador();	}

}
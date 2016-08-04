import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class TopoHil extends Applet implements ActionListener,Runnable {
	Thread hilo;
	Label score;
	JButton botones[];
	int sleepTime, cont, puntos = 0;
    ImageIcon hoyo;
	ImageIcon rip,topo;
	JPanel p1,p2;

	public void init(){
		sleepTime = 2000;		
		cont = 10;	
		hoyo=new ImageIcon("hoyo.jpg");
		topo=new ImageIcon("topo.jpg");
		rip=new ImageIcon("rip.jpg");		
		botones= new JButton[20];
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(new GridLayout(4,5));
		for(int i = 0; i < botones.length; i++) {
			p1.add(botones[i] = new JButton());
			botones[i].addActionListener(this);
		}
		p2.add(score = new Label("Puntuación:            "));
		add("South",p1);
		add("North",p2);
		hilo = new Thread(this);
		hilo.start();
	}

	public void run() {
		while (cont -- > 0) {
			for(int i = 0; i < botones.length; i++) {
				if((Math.random()*2) < 0.5)
					p1.add(botones[i] = new JButton(topo));
				else
					p1.add(botones[i] = new JButton(hoyo));
			}
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				return;
			}
		}
	}

	public void actionPerformed (ActionEvent e){
		JButton aux=(JButton) e.getSource();
		if(aux.getIcon().equals(topo)){
			puntos += 500;
			score.setText("Puntuación: " + puntos);
			aux.setIcon(rip);		
		}		
		
	}

	
}
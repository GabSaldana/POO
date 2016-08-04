import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class TopoHilo extends Applet implements ActionListener,Runnable {
	Thread hilo;	
	JButton botones[];
	Label score;
	int sleepTime, cont, puntos = 0;
	ImageIcon imas[];
	JPanel p1,p2;
	
	public void init() {
		sleepTime = 2000;		
		cont = 10;		
		botones = new JButton[20];
		imas = new ImageIcon[3];
		imas[0] = new ImageIcon("topo.jpeg");
		imas[1] = new ImageIcon("hoyo.jpeg");
		imas[2] = new ImageIcon("rip.jpeg");
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
					botones[i].setIcon(imas[0]);
				else
					botones[i].setIcon(imas[1]);
			}
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				return;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){         
		ImageIcon topo = imas[0];
		JButton casilla;
		casilla = (JButton)e.getSource();
		if(topo == casilla.getIcon()){
			casilla.setIcon(imas[2]);
			puntos += 500;
			score.setText("Puntuación: " + puntos);
		}
	}
}	
		
		

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Topo extends Applet implements
 ActionListener{
	JButton botones[];
	int puntuacion;
    ImageIcon hoyo;
	ImageIcon rip,topo;
	public void init(){
		puntuacion=0;
		hoyo=new ImageIcon("hoyo.jpg");
		topo=new ImageIcon("topo.jpg");
		rip=new ImageIcon("rip.jpg");		
		botones= new JButton[20];
		setLayout(new GridLayout(4,5));
		for(int i=0;i<botones.length;i++){
			if(Math.random()<0.3){						
			add(botones[i]=new JButton(topo));
			}
			else
			add(botones[i]=new JButton(hoyo));
			

			botones[i].addActionListener(this);		
		  }
	}
	public void actionPerformed (ActionEvent e){
		JButton aux=(JButton) e.getSource();
		if(aux.getIcon().equals(topo)){
			puntuacion=puntuacion+1;
			aux.setIcon(rip);		
		}		

		
	}
}

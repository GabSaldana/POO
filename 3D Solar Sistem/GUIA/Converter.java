import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Converter extends Applet implements ActionListener{
    Button b1,b2;
    TextField t;
    Label l;
    double K,C;
    public void init(){

        b1=new Button("ªK->ªC ");
        b2=new Button("ªC->ªK");
        t=new TextField(10);
        l=new Label();
        add(b1);add(b2);add(t);add(l);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerfomed(ActionEvent e){
        Button aux=(Button) e.getSource();
            if(aux==b1){
                l.setText("ªK=" + Double.parseDouble(t.getText()) + 273.15 );
            }
            if(aux==b2){
                l.setText("ªC=" + (Double.parseDouble(t.getText())-273.15 ) );
            }
    
    }

}

//package sistemasolar;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;


public class reproductor extends JFrame{
        private Player mediaPlayer; 
        private Component video;
        private Component controles;
public reproductor (URL url){
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            
            try {
                Manager.setHint(Manager.LIGHTWEIGHT_RENDERER,true);
                mediaPlayer = Manager.createRealizedPlayer(url);
                video = mediaPlayer.getVisualComponent();
                video.setSize(600,400);
                video.setVisible(true);
                if(video != null)
                    panel.add("Center",video);
                
                controles = mediaPlayer.getControlPanelComponent();
                controles.setSize(600,100);
                controles.setVisible(true);
                if(controles != null)
                    panel.add("South",controles);
                add(video);
                add(panel);
                mediaPlayer.start();
                panel.updateUI();
                
                
                
            } catch (    IOException | NoPlayerException | CannotRealizeException ex) {
                Logger.getLogger(reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}

}

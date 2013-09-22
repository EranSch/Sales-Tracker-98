package sh.eran.ctu.IT251;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @version 1.0
 * @author Eran
 */
public class Animator implements ActionListener {

   private Splash splash;
   private long startTime = 0;
   Timer timer = null;

    public Animator(Splash splash) {
        this.splash = splash;
        startTime = System.currentTimeMillis();
        timer = new Timer(250, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( splash.getDuration(startTime) < 28000 ){
             // This is everything until the big pause.
            splash.setTextLine(0);
        } 
        else if( splash.getDuration(startTime) > 28000 && splash.getDuration(startTime) < 42000 ) {
            // During the pause
            splash.setTextLine(1);
            timer.setDelay(1000);
        }
        else if( splash.getDuration(startTime) > 42000 && splash.getDuration(startTime) < 53000 ) {
            // After!!!!!
            splash.setDrawBg(false);
            splash.setTextLine(2);
            timer.setDelay(50);
        }
        else if( splash.getDuration(startTime) > 53000 && splash.getDuration(startTime) < 69000 ){
            splash.setTextLine(3);
        }else{
            timer.stop();
        }
        
        splash.setDrawStars( !splash.isDrawStars() );
        splash.repaint();
        
    }
   
   

} // end class

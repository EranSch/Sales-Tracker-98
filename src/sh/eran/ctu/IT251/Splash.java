/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sh.eran.ctu.IT251;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 1.0
 * @author Eran
 */
public class Splash extends JPanel{

    public long getDuration(long startTime) {
       return System.currentTimeMillis() - startTime;
    }

    public void playMusic() {
        AudioInputStream audioIn = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(Splash.class.getResource("/sh/eran/ctu/IT251/assets/80s.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioIn.close();
            } catch (IOException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    boolean drawStars = false;
    boolean logo = true;
    boolean drawBg = true;
    boolean drawText = true;
    int textLine = 0;
    
    String [] text = {
        " A FOOCORP PRODUCTION ",
        "THE FUTURE OF SALES...",
        "       IS NOW !!!     ",
        "Sales to date: "
    };
    
    
    @Override
    public void paint(Graphics g1) {
        
        Graphics2D g = (Graphics2D) g1;
        
        int centerX = this.getWidth()/2;
        int centerY = this.getHeight()/2;
        
        g.setColor(Color.BLACK);
        
        if( drawBg ){
            g.fillRect(0, 0, this.getWidth() , this.getHeight() );
        }
        
        if( drawStars ) {
            g.setColor(Color.GREEN);
            drawStars(true, g);
            g.setColor(Color.WHITE);
            drawStars(false, g);
        }
        
        BufferedImage logoGraphic = null;
        try {
            logoGraphic = ImageIO.read(getClass().getResource("/sh/eran/ctu/IT251/assets/logo.png"));
        } catch (IOException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( logo ) {
            g.drawImage(logoGraphic, null, (centerX - ( logoGraphic.getWidth() /2) ), (centerY - ( logoGraphic.getHeight() /2 )) );
        }
        
        if ( drawText ){
            g.setColor(Color.WHITE);
            Font bigger = new Font(g.getFont().getName(), Font.BOLD, 40);
            g.setFont(bigger);
            g.drawString(text[textLine], (centerX - 250 ), (centerY + 200 ));
        }
         
    }

    public boolean isDrawStars() {
        return drawStars;
    }

    public void setDrawStars(boolean drawStars) {
        this.drawStars = drawStars;
    }

    public boolean isDrawBg() {
        return drawBg;
    }

    public void setDrawBg(boolean drawBg) {
        this.drawBg = drawBg;
    }
    
    public void setTextLine( int i ){
       this.textLine = i;
    }
    
    
    private GeneralPath star( int startX, int startY ){
        
        GeneralPath star = new GeneralPath();
        
        startX += this.getWidth()/2 ;
        startY += this.getHeight()/2;
        
        star.moveTo(startX, startY);
        star.lineTo(startX + 25, startY - 70);
        star.lineTo(startX + 50, startY );
        star.lineTo(startX - 10, startY - 50);
        star.lineTo(startX + 65, startY - 50);
        star.lineTo(startX, startY);
        
        return star;
        
    }

   
    public void init( Splash splash, double sales ){
       
        JFrame splashWindow = new JFrame("Hooray!");
        splashWindow.setBounds(100, 100, 900, 700);
        
        splash.playMusic();
        splashWindow.add(splash);
               
        splashWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        splashWindow.setVisible(true);
        
        double totalSales = 0;
        totalSales += sales;
        text[3] += String.valueOf(totalSales);
                
        Animator a = new Animator(splash);
        
    }

    private void drawStars( boolean fill, Graphics2D g ) {
        Random rg = new Random();
                
        for ( int i=0; i < 100; i++ ){
            
            int xOffset = rg.nextInt(i+3) * 5;
            int yOffset = rg.nextInt(i+3) * 5;
            
            if( i % 2 == 0 ) xOffset = -(xOffset);
            if( i % 3 == 0 ) yOffset = -(yOffset);
            
            if(fill){
                g.fill( star(
                            (xOffset),
                            (yOffset)
                        ));
            }else{
                g.draw( star(
                            (xOffset),
                            (yOffset)
                        ));
            }
            
            
        }    
    }  

} // end class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */
public class NewPanel  extends JPanel implements ActionListener{
    
    private Timer timer;
    int i =0;
    int j =0;
    int xSpeed = 20;
    int ySpeed = 20;
    int cx = 0;
    int cy =0;
    boolean changeX = false;
    boolean changeY = false;
    
    public NewPanel(){
        timer = new Timer(25, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Color door = new Color(103,168,255);
        Color roof = new Color(106,194,255);
        
            g.setColor(Color.BLACK);
            g.drawRect(0+i, 685+j, 100, 70);
            
            cx = 0+i;
            cy = 700+j;
            
            if (cx >= 900 || cx <=0) {
                changeX = true;
                xSpeed*= (-1);
            }
            if (cy >= 725 || cy <= 12) {
                changeY = true;
                ySpeed*= (-1);
            }
            
            g.setColor(roof);
            g.drawRect(0+i, 700+j, 100, 30);
            g.fillRect(0+i, 700+j, 100, 30);
            g.setColor(Color.BLACK);
            g.fillOval(15+i, 730+j, 25, 25);
            g.fillOval(60+i, 730+j, 25, 25);

            //roof
            Polygon Roof = new Polygon();
                Roof.addPoint(45+i, 685+j);
                Roof.addPoint(60+i, 685+j);
                Roof.addPoint(85+i, 700+j);
                Roof.addPoint(20+i, 700+j);  
            g.setColor(door);
            g.fillPolygon(Roof);
            g.drawPolygon(Roof);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (changeX) {
            i += xSpeed;
        } else {
            i+= xSpeed;
        }
        if (changeY) {
            j-=ySpeed;
        } else {
            j-=ySpeed;
        }
        repaint(); 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package racegame;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author android-hw
 */
public class RaceGame extends JFrame implements KeyListener{

    RaceGame(){
        super("RaceGame");
        constructFrame();
        startRace();
    }
    
    JLabel racetrack;
    JLabel car;
    JLabel car_blue;
    JLabel car_green;
    JLabel car_yellow;
    JTextField points;
    int x = 140;
    int y = 350;
    boolean[] keys = new boolean[100];
    
    private void constructFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);        
        addKeyListener(this);
        
        
        racetrack = new JLabel(new ImageIcon(RaceGame.class.getResource("/images/racing_track.gif")));
        car = new JLabel(new ImageIcon(RaceGame.class.getResource("/images/car_red.png")));
        
        car_blue = new JLabel(new ImageIcon(RaceGame.class.getResource("/images/car_blue.png")));
        car_green = new JLabel(new ImageIcon(RaceGame.class.getResource("/images/car_green.png")));
        car_yellow = new JLabel(new ImageIcon(RaceGame.class.getResource("/images/car_yellow.png")));
        points = new JTextField();
        
        
        car.setBounds(x, y, 100, 100);
        points.setBounds(333, 12, 100, 30);
        points.setFont(new Font("Arial", 0, 20));
        points.disable();
        
        
        racetrack.add(points);
        racetrack.add(car);
        racetrack.add(car_blue);
        racetrack.add(car_green);
        racetrack.add(car_yellow);
        
        
        getContentPane().add(racetrack);
        
        pack();
        setVisible(true);
        
    }
    
    public void startRace(){
        
        ArrayList<Car> al = new ArrayList();
        
        Car blue = new Car(car_blue, 85);
        Car green = new Car(car_green, 140);
        Car yellow = new Car(car_yellow, 195);
        
        al.add(blue); al.add(green); al.add(yellow);
        ThreadControl c = new ThreadControl(al, car, points);
        
        while(true){
            try {
                update();
                Thread.sleep(70);
            } catch (InterruptedException ex) {
                Logger.getLogger(RaceGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        new RaceGame();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

            keys[e.getKeyCode()] = true;    
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
            keys[e.getKeyCode()] = false;
    }
    
    public void update(){
            if(keys[KeyEvent.VK_RIGHT] && x<200)
                {car.setBounds(x+=10, y, 100, 100);}; //stay in track
                 
            if(keys[KeyEvent.VK_LEFT] && x>80)
                {car.setBounds(x-=10, y, 100, 100);};
                
            if(keys[KeyEvent.VK_UP])
                {car.setBounds(x, y-=10, 100, 100);};
                
            if(keys[KeyEvent.VK_DOWN])
                {car.setBounds(x, y+=10, 100, 100);};
                            
    }

    
}

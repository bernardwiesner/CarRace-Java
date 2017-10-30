/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package racegame;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author android-hw
 */
public class ThreadControl extends Thread{
    
    ArrayList<Car> al;
    JLabel car;
    int position_y = 100;
    JTextField points;
    int num = 0;
    ThreadControl(ArrayList al, JLabel car, JTextField points){
        start();
        this.car = car;
        this.al = al;
        this.points = points;
    }
    
        public void run(){
            while(true){
                    points.setText(String.valueOf(num++));
                for(Car c: al){                                         

                     position_y = c.position_y;
                     
                     if(car.getBounds().getX() >= c.position_x-30 && car.getBounds().getX() <= c.position_x+30 &&
                           car.getBounds().getY() > c.position_y-80 && car.getBounds().getY() < c.position_y+80){
                         for(Car car: al){
                             car.stop();
                             this.car.disable();
                             
                         }
                         return;
                     }
                }  
                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                
        }
            
            

    
    
}

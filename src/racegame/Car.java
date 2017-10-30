/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package racegame;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author android-hw
 */
public class Car extends Thread{
    JLabel car;
    Random r;
    int random;
    int position_y;
    int position_x;
    
    Car(JLabel car, int position_x){
        this.car = car;
        this.position_x = position_x;
        start();
    }
    
        public void run(){
            while(true){
                position_y=-100;
                
                
                try {
                    sleep(position_x*20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }

                car.setBounds(position_x, position_y, 100, 100);
                while(car.getY() < 450){


                    car.setBounds(position_x, position_y, 100, 100);
                    position_y+=3;
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
              
    
}

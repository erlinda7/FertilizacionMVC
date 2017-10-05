/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class TimerExample {

    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask myTask = new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                // whatever you need to do every 2 seconds 
                //new ImageIcon(getClass().getResource("/img/arcilloso.jpg"))
                System.out.println("contador: " + i);
                if (i < 4) {
                    i++;
                } else {
                    i = 0;
                }
                

            }
        };

        timer.schedule(myTask, 2000, 2000);
    }
}

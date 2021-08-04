package com.mashibing.tanke;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: mfy
 * @Date: 2021-08-03-19:46
 * @Description: com.mashibing.tanke
 */
public class Main {

    public static void main(String[] args) {

            TankeFrame tankeFrame = new TankeFrame();
            while(true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tankeFrame.repaint();
            }
    }
}

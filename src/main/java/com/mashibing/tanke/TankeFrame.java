package com.mashibing.tanke;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: mfy
 * @Date: 2021-08-03-23:24
 * @Description: com.mashibing.tanke
 */
public class TankeFrame extends Frame {

    Integer x = 200, y = 200;

    public TankeFrame() {
        this.setVisible(true);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("tan-ke");
        this.addKeyListener(new MyKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        }


        @Override
        public void paint (Graphics graphics){
            graphics.fillRect(x, y, 50, 50);
            //x += 10;
            //y+=10;
        }

        // 处理键盘事件
        class MyKeyListener extends KeyAdapter {

        boolean bR = false;
        boolean bL = false;
        boolean bU = false;
        boolean bD = false;

            // 按下按钮触发
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                System.out.println("-----------------");
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = true;
                        break;
                    case KeyEvent.VK_UP:
                        bU = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = true;
                        break;
                    default:
                        break;
                }
//            x += 200;
//            repaint();
//            System.out.println("key pressed");
            }

            // 抬起按钮触发
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("key released");
                int key = e.getKeyCode();
                System.out.println("-----------------");
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    default:
                        break;
                }
            }
        }

}

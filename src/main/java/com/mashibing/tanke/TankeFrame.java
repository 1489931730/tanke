package com.mashibing.tanke;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mfy
 * @Date: 2021-08-03-23:24
 * @Description: com.mashibing.tanke
 */
public class TankeFrame extends Frame {

    Tank tank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);
    List<Bullet> bulletList = new ArrayList<>();
    // Bullet bullet = new Bullet(220, 220, Dir.DOWN);
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    // 敌方坦克
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public TankeFrame() {
        this.setVisible(true);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
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

    Image offScreenImage = null;

    //解决双缓冲
    @Override
    public void update(Graphics graphics) {

        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        graphics.drawImage(offScreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawString("子弹的数量" + bulletList.size(), 10, 60);
        graphics.drawString("敌人坦克的数量" + tanks.size(), 10, 80);
        graphics.drawString("爆炸的数量" + explodes.size(), 10, 100);
        graphics.setColor(color);
        tank.paint(graphics);
        //bullet.paint(graphics);
//        for (Bullet bullet : bulletList) {
//            bullet.paint(graphics);
//        }
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(graphics);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(graphics);
        }
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(graphics);
        }
        // 子弹和坦克碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int i1 = 0; i1 < tanks.size(); i1++) {
                bulletList.get(i).collideWith(tanks.get(i1));
            }
        }

        // 图片爆炸效果
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
            setMainTainkDir();
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
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTainkDir();
        }

        private void setMainTainkDir() {

            if (!bL && !bU && !bR && !bD) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bL) tank.setDir(Dir.LEFT);
                if (bU) tank.setDir(Dir.UP);
                if (bR) tank.setDir(Dir.RIGHT);
                if (bD) tank.setDir(Dir.DOWN);
            }
        }

    }


}

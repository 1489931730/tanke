package com.mashibing.tanke;

import java.awt.*;

/**
 * @Auther: mfy
 * @Date: 2021-08-06-17:19
 * @Description: com.mashibing.tanke
 *  子弹类
 */
public class Bullet {

    private static final int SPEED = 5;
    private int x, y;
    private Dir dir;
    private static int WIDTH= 5,HEIGHT=5;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics graphics){
        Color color = graphics.getColor();
        graphics.setColor(color.RED);
        graphics.fillRect(x, y, WIDTH, HEIGHT);
        graphics.setColor(color);
        
        move();
    }

    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }
}

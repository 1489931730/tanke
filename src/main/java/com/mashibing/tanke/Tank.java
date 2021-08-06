package com.mashibing.tanke;

import java.awt.*;

/**
 * @Auther: mfy
 * @Date: 2021-08-06-16:11
 * @Description: com.mashibing.tanke
 */
public class Tank {
    private int x , y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    private boolean moving = false;
    private TankeFrame tf = null;


    public Tank(int x, int y, Dir dir,TankeFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, 50, 50);
        graphics.setColor(color);
        move();
    }

    private void move() {

        if (!moving) return;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        tf.bullet = new Bullet(this.x,this.y,this.dir);
    }
}

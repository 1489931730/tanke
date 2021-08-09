package com.mashibing.tanke;

import sun.plugin.liveconnect.LiveConnect;

import java.awt.*;

/**
 * @Auther: mfy
 * @Date: 2021-08-06-17:19
 * @Description: com.mashibing.tanke
 * 子弹类
 */
public class Bullet {

    private static final int SPEED = 8;
    private final TankeFrame tankeFrame;
    private int x, y;
    private Dir dir;
//    private static int WIDTH = 5, HEIGHT = 5;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private boolean living = true;

    public Bullet(int x, int y, Dir dir,TankeFrame tankeFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankeFrame = tankeFrame;
    }

    public void paint(Graphics graphics) {
        if (!living){
            tankeFrame.bulletList.remove(this);
        }
        switch(dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

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
        if (x < 0 || y < 0 || x > TankeFrame.GAME_WIDTH || y > TankeFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        Rectangle rectangle = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rectangle.intersects(rectangle2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}

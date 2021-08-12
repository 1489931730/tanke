package com.mashibing.tanke;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: mfy
 * @Date: 2021-08-06-16:11
 * @Description: com.mashibing.tanke
 * 坦克类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 4;

    private boolean moving = true;
    private TankeFrame tf = null;
    public boolean living = true;
    private Random random = new Random();
    // 坦克好坏区分
    private Group group = Group.BAD;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    public Tank(int x, int y, Dir dir, Group group, TankeFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics graphics) {

        if (!living) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                graphics.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        // 坦克随机发射子弹
        if (random.nextInt(10) > 5) this.fire();

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void fire() {
        int bX = this.x + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.WIDTH / 2;
        tf.bulletList.add(new Bullet(bX, bY, this.dir,this.group, this.tf));
    }

    public void die() {
        this.living = false;
    }
}

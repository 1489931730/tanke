package com.mashibing.tanke;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    Rectangle rectangle = new Rectangle();


    public Tank(int x, int y, Dir dir, Group group, TankeFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics graphics) {

        if (!living) tf.tanks.remove(this);
        switch (dir) {
            case LEFT:
                graphics.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                graphics.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                graphics.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                graphics.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }

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
        rectangle.x = this.x;
        rectangle.y = this.y;
        // 坦克随机发射子弹
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.randomDir();
        }
        this.bounsCheck();
    }

    // 边界检测
    private void bounsCheck() {

        if (this.x < 2) x = 2;
        if (this.y < 30) y = 30;
        if (this.x > TankeFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankeFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankeFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankeFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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
        tf.bulletList.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die() {
        this.living = false;
    }
}

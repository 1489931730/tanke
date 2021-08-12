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
    Rectangle rectangle = new Rectangle();
//    private static int WIDTH = 5, HEIGHT = 5;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    private boolean living = true;

    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankeFrame tankeFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankeFrame = tankeFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics graphics) {
        if (!living) {
            tankeFrame.bulletList.remove(this);
        }
        switch (dir) {
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
        // update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
        if (x < 0 || y < 0 || x > TankeFrame.GAME_WIDTH || y > TankeFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (rectangle.intersects(tank.rectangle)) {
            tank.die();
            this.die();
            // 爆炸位置在坦克所在中心点
            int eX = tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
            int eY = tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
            tankeFrame.explodes.add(new Explode(eX, eY, tankeFrame));
        }
    }

    private void die() {
        this.living = false;
    }
}

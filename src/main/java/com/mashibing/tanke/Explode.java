package com.mashibing.tanke;

import java.awt.*;

/**
 * @Auther: mfy
 * @Date: 2021-08-06-17:19
 * @Description: com.mashibing.tanke
 * 
 */
public class Explode {

    private final TankeFrame tankeFrame;
    private int x, y;
//    private static int WIDTH = 5, HEIGHT = 5;

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y, TankeFrame tankeFrame) {
        this.x = x;
        this.y = y;
        this.tankeFrame = tankeFrame;
//        new Audio("audio/explode.wav").run();
    }

    public void paint(Graphics graphics) {

        graphics.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) step = 0;
    }
}



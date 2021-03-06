package com.mashibing.tanke;

import com.mashibing.tanke.util.ConfigMgr;

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
        int tankeCount = Integer.parseInt((String) ConfigMgr.tankeCount("initTankeCount"));
        // 初始化敌方坦克
        for (int i = 0; i < tankeCount; i++) {
            tankeFrame.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tankeFrame));
        }

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tankeFrame.repaint();
        }
    }
}

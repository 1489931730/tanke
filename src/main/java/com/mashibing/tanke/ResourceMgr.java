package com.mashibing.tanke;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther: mfy
 * @Date: 2021-08-08-16:40
 * @Description: com.mashibing.tanke
 */
public class ResourceMgr {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // 好坦克方向
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            // 坏坦克方向
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            // 子弹方向
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageUtil.rotateImage(bulletU,180);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletL = ImageUtil.rotateImage(bulletU,-90);

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

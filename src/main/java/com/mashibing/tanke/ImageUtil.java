package com.mashibing.tanke;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther: mfy
 * @Date: 2021-08-12-14:06
 * @Description: com.mashibing.tanke
 * 图片工具类
 */
public class ImageUtil {
    public static BufferedImage rotateImage(final BufferedImage bufferedImage, final int degree) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage image;
        Graphics2D graphics2D;
        (graphics2D = (image = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );
        graphics2D.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2D.drawImage(bufferedImage, 0, 0, null);
        graphics2D.dispose();
        return image;
    }
}

package com.mashibing.tanke.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Auther: mfy
 * @Date: 2021-08-08-15:28
 * @Description: com.mashibing.tanke.test
 */
public class ImageTest {

    @Test
    void test(){
        try {
            //BufferedImage image = ImageIO.read(new File("E:/Download/image/vz2rptfbihb.jpg"));
            BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("image/vz2rptfbihb.jpg"));
            // 判断不为空(断言)
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

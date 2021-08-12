package com.mashibing.tanke.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: mfy
 * @Date: 2021-08-12-18:47
 * @Description: com.mashibing.tanke.util
 */
public class ConfigMgr {
    static Properties properties = new Properties();

    public static Object tankeCount(String key){
        try {
            properties.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties == null){
            return null;
        }else{
            return properties.get(key);
        }
    }
}

package com.harlan.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 工具类 GameUtil
 * @author Harlan
 */
public class GameUtil {

    /**
     * 最好将工具类构造器私有化
     */
    private GameUtil(){

    }

    /**
     * 返回指定路径文件的图片对象
     * @param path 路径
     * @return 图片对象
     */
    public static Image getImage(String path){
        BufferedImage img = null;
        try{
            URL url = GameUtil.class.getClassLoader().getResource(path);
            img = ImageIO.read(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return img;
    }
}

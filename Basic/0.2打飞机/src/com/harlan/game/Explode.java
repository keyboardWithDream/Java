package com.harlan.game;

import com.harlan.constant.Constant;

import java.awt.*;

/**
 * 爆炸类
 * @author Harlan
 */
public class Explode {

    static Image[] images = new Image[16];
    static {
        for (int i = 0; i < Constant.EXPLODE_FPS; i++) {
            images[i] = GameUtil.getImage("./img/explode/e"+(i + 1)+".gif");
            images[i].getWidth(null);
        }
    }

    private int count;

    public void draw(Graphics g){
        if (count <= Constant.EXPLODE_PHOTOTS){
            g.drawImage(images[count],(int)this.x,(int)this.y,null);
            count++;
        }
    }


    /**
     * 爆炸位置
     */
    private double x, y;

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

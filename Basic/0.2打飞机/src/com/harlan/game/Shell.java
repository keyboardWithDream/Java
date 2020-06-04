package com.harlan.game;

import com.harlan.constant.Constant;
import com.harlan.object.GameObject;

import java.awt.*;
import java.util.Random;

/**
 * 炮弹类
 * @author Harlan
 */
public class Shell extends GameObject {

    /**
     * 角度
     */
     private double degree;

    /**
     * 初始化炮弹
     */
    public Shell(){
        Random random = new Random();
        this.setX(150);
        this.setY(150);
        this.setWidth(10);
        this.setHeight(10);
        this.setSpeed(3);
        degree = Math.random() * Math.PI * 2;
    }


    public void draw(Graphics g){
        Color c = g.getColor();
        //颜色
        g.setColor(Color.pink);
        //填充
        g.fillOval((int)getX(),(int)getY(),getWidth(),getHeight());
        //位置
        setX(getX() + getSpeed() * Math.cos(degree));
        setY(getY() + getSpeed() * Math.sin(degree));

        g.setColor(c);
        if (getX() < Constant.TITLE_HEIGHT || getX() > Constant.GAME_WIDTH - Constant.SHELL_WIDTH){
            degree = Math.PI - degree;
        }
        else if (getY() < Constant.BOTTOM_HEIGHT || getY() > Constant.GAME_HEIGHT - Constant.SHELL_HEIGHT){
            degree = -degree;
        }
    }
}

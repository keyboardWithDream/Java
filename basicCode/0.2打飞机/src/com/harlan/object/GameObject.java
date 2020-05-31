package com.harlan.object;

import java.awt.*;

/**
 * 游戏物体的父类
 * @author Harlan
 */
public class GameObject {

    private Image img;
    private double x, y;
    private int speed;
    private int width, height;

    /**
     * 画图
     * @param g 画笔
     */
    protected void drawSelf(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

    /**
     * 物体所在的矩形,便于碰撞检测
     * @return 物体的矩形
     */
    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, width, height);
    }

    /**
     * 构造器
     */
    protected GameObject() {
    }

    protected GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    protected GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    /**
     * getter setter
     * @return 物体属性
     * @param img 图片
     */
    protected Image getImg(Image img) {
        return this.img;
    }

    protected void setImg(Image img) {
        this.img = img;
    }

    public double getX() {
        return x;
    }

    protected void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    protected void setY(double y) {
        this.y = y;
    }

    protected int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}

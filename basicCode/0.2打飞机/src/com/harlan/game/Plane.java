package com.harlan.game;

import com.harlan.constant.Constant;
import com.harlan.object.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 飞机类
 * @author Harlan
 */
public class Plane extends GameObject {

     private boolean left, up, right, down;
     protected boolean live = true;


    /**
     * 增加某个方向
     * @param e 方向
     */
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            default:
                break;
        }
    }

    /**
     * 取消某个方向
     * @param e 方向
     */
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            default:
                break;
        }
    }

    /**
     * 画飞机
     * @param g 画笔
     */
    @Override
    public void drawSelf(Graphics g) {
        super.drawSelf(g);
        if (live){
            if (left){
                if (getX() <= this.getWidth()){
                    this.setX(this.getWidth());
                }else {
                    this.setX(getX() - getSpeed());
                }
            }
            else if (right){
                if (getX() >= Constant.GAME_WIDTH - this.getWidth()){
                    this.setX(Constant.GAME_WIDTH - this.getWidth());
                }else {
                    this.setX(getX() + getSpeed());
                }
            }
            else if (up){
                if (getY() <= this.getHeight()){
                    this.setY(this.getHeight());
                }else {
                    this.setY(getY() - getSpeed());
                }
            }
            else if (down){
                if (this.getY() >= Constant.GAME_HEIGHT - this.getWidth() - 23){
                    this.setHeight(Constant.GAME_HEIGHT - this.getHeight());
                }else {
                    this.setY(getY() + getSpeed());
                }
            }
        }else {
            System.out.println("游戏结束...");
        }
    }

    /**
     * 飞机位置
     * @param img 图片
     * @param x x位置
     * @param y y位置
     */
    public Plane(Image img, double x, double y, int speed) {
        super(img, x, y);
        this.setImg(img);
        this.setX(x);
        this.setY(y);
        this.setSpeed(speed);
        this.setWidth(img.getWidth(null));
        this.setHeight(img.getHeight(null));
    }
}

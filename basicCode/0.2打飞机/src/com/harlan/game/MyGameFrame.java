package com.harlan.game;

import com.harlan.constant.Constant;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * 飞机游戏主窗口
 * @author Harlan
 */
public class MyGameFrame extends Frame {

    /**
     * 双缓冲
     */
    private Image offScreenImage = null;

    @Override
    public void update(Graphics g){
        if (offScreenImage == null) {
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }


    /**
     * 导入图片
     */
    Image planeImg = GameUtil.getImage("./img/plane.png");
    Image background = GameUtil.getImage("./img/bg.jpg");


    /**
     * 飞机对象
     * 炮弹对象-数组
     * 爆炸对象
     * 时间对象
     */
    Plane plane = new Plane(planeImg, 250, 250,5);
    Shell[] shells = new Shell[50];
    Explode explode;
    Date statTime = new Date();
    Date endTime;
    int livedTime;


    /**
     * 窗口绘制 自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background,0,0,null);
        plane.drawSelf(g);
        for (Shell shell : shells) {
            shell.draw(g);
            //碰撞检测
            boolean collision = shell.getRect().intersects(plane.getRect());
            if (collision){
                plane.live = false;
                if (explode == null){
                    explode = new Explode(plane.getX(),plane.getY());
                    endTime = new Date();
                    livedTime = (int)((endTime.getTime() - statTime.getTime()) / 1000);
                }
                explode.draw(g);
            }
            //计时间功能
            if (!plane.live){
                Font fEndTime = new Font("宋体", Font.BOLD, 50);
                Font fOver = new Font("宋体", Font.BOLD, 80);
                g.setFont(fEndTime);
                Color c = g.getColor();
                g.setColor(Color.red);
                g.drawString("时间: " + livedTime + " 秒",110,150);
                g.setFont(fOver);
                g.drawString("游戏结束!",70,300);
                g.setColor(c);
            }
        }
    }


    /**
     *反复重画窗口
     */
    class PaintThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                //重画窗口
                repaint();
                //40ms 暂停一次
                try{
                    Thread.sleep(40);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 初始化窗口
     */
    public void launchFrame(){
        this.setTitle("飞机大战");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocation(700,300);
        //关闭窗口
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //启动重画窗口的线程
        new PaintThread().start();
        //给窗口怎加键盘监听
        addKeyListener(new KeyMonitor());
        //创建50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }


    /**
     * 键盘监听内部类
     */
    class KeyMonitor extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            plane.minusDirection(e);
        }
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}

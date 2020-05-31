package billiards;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{

    //图片对象
    Image ball = Toolkit.getDefaultToolkit().getImage("Billiards/images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("Billiards/images/desk.jpg");

    //小球坐标
    double x =100;
    double y =100;
    double degree = 3.14 / 3; //弧度,此处为60°.

    //画窗口的方法
    @Override
    public void paint(Graphics g){
        System.out.println("Test");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball, (int)x, (int)y,null);

        x += 10 * Math.cos(degree);
        y += 10 * Math.sin(degree);

        //上下边界: 500:窗口的高度;40:桌子的高度;30是求的直径;40是标题栏的高度
        if(y > 500 - 40 - 30 || y < 80) {
            degree = -degree;
        }
        //左右边界:
        if (x > 856 - 40 - 30 || x < 40){
            degree = 3.14 - degree;
        }
    }

    //窗口加载
    void launchFrame(){
        setSize(856,500);
        setLocation(1200,300);
        setVisible(true);

        //重画窗口,每秒25次
        while (true){
            repaint();
            try {
                Thread.sleep(40); //40ms 暂停
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //main()方法是程序执行的入口
    public static void main(String[] args) {
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

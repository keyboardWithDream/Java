package construction_method;

class Point{
    double x, y;

    //构造方法 和 类名一致 不需要返回值
    public Point(double x, double y){
        //this 表示创建好的对象
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p){
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}

public class Constructer {
    public static void main(String[] args) {
        Point p = new Point(3.0, 4.0);
        Point origin = new Point(0.0, 0.0);
        System.out.println(p.getDistance(origin));
    }
}
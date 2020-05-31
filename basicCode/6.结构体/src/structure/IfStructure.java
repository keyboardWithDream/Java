package structure;


import java.util.Scanner;

public class IfStructure{

    public static void main(String[] args) {
        float[] triangle=new float[3];

        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("请输入第%d条边长:", i+1);
            triangle[i] = scanner.nextInt();
        }

        //判断三角形 计算周长和面积
        float a = triangle[0], b = triangle[1], c = triangle[2];
        if (a + b > c && a + c > b && b + c > a && b + a > c){
            System.out.println("三角形周长为:" +  (a + b +c));
            //海伦公式
            float p = (a + b + c) / 2;
            System.out.println("三角形面积为:" + Math.sqrt(p * (p -a) * (p -b) * (p -c)));
        }else {
            System.out.println("不能构成三角形.");
        }
    }
}

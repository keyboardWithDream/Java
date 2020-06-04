package structure;

public class ForStucture {
    //从0 累加到 100
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println("==================");

        //嵌套循环
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println("==================");

        //乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t",i ,j , (i * j));
            }
            System.out.println();
        }

        System.out.println("==================");

        //用while计算100以内奇数,偶数和
        int i = 1, oddSum = 0, evenSum = 0;
        while (i <= 100){
            if(i % 2 == 0) {
                evenSum += i;
            }else {
                oddSum += i;
            }
            i++;
        }
        System.out.printf("奇数和:%d,偶数和:%d\n", oddSum, evenSum);

        System.out.println("=================");

        //用循环输出1-1000内能被5整除的数,且每行输出5个
        int count = 0;
        for (int j = 1; j <= 1000; j++) {
            if (j % 5 == 0) {
                System.out.printf("%d\t", j);
                count++;
            }
            if (count == 5){
                System.out.println();
                count = 0;
            }
        }

    }
}

package structure;

public class breakAndcontinueStatement {

    public static void main(String[] args) {
        //100 - 150间不能被3整除的数输出,每行5个
        int count = 0;
        for (int i = 100; i <  500; i++) {
            if (i == 150){
                //到150次 结束循环
                break;
            }else if(i % 3 == 0){
                //本次循环结束,继续下一次循环
                continue;
            }
            System.out.printf("%d\t", i);
            count ++;
            if (count % 5 == 0){
                System.out.println();
            }
        }
    }
}

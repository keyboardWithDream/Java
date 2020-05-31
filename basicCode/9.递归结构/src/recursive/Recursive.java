package recursive;

/**
 * 递归:自己调用自己
 * 递归结构 = 递归头(结束) + 递归体(调用)
 */
public class Recursive {

    public static void main(String[] args) {
        //返回当前时刻 单位ms
        long startTime = System.currentTimeMillis();
        System.out.printf("%d的阶层的结果:%s\n", 10, factorial(10));
        long endTime = System.currentTimeMillis();
        System.out.printf("递归耗时:%s\n", endTime - startTime);

        //推荐循环体
        long startLoop = System.currentTimeMillis();
        System.out.printf("%d的阶层的结果:%s\n", 10, factoriateLoop(10));
        long endLoop = System.currentTimeMillis();
        System.out.printf("循环耗时:%s", endLoop - startLoop);
    }

    /**
     * 递归
     * @param n 递归次数
     * @return  阶层值
     */
    static long factorial(int n){
        if(n == 1){
            //递归头
            return 1;
        }else {
            //递归体
            return n * factorial(n - 1);
        }
    }

    /**
     * 循环求阶层
     * @param n 阶层数
     * @return  阶层值
     */
    static long factoriateLoop(int n){
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
}

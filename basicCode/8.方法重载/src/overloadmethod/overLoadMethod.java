package overloadmethod;

/**
 * 重载的方法;实际是完全不同的方法,只是名称相同
 * 重载条件:1.形参类型 2.形参个数 3.形参顺序 4.只有返回值不同不构成方法的重载
 *
 * 不构成重载: int method(String str){}  与   void method(String str){}
 * 不构成重载: int method(String str){}  与   int method(String s){}
 */

public class overLoadMethod {
    public static void main(String[] args) {
        //静态方法直接调用
        int res1 = add(1, 2);
        int res2 = add(1, 2, 3);
        System.out.println(res1 + " " + res2);
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }

    /**
     * add 方法的重载(参数个数不同)
     * @param num1 参数1
     * @param num2 参数2
     * @param num3  参数3
     * @return  求和
     */
    public static int add(int num1, int num2, int num3){
        return num1 + num2 +num3;
    }
}

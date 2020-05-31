package method;
/**
 * 方法是一段用来完成特定功能的代码片段,类似于其它语言函数
 * [修饰符1][修饰符2][...] 返回值类型 方法名(形式参数列表){ Java 语句...}
 */

public class Method {

    public static void main(String[] args) {
        //成员方法调用 先实例化对象
        Method method = new Method();
        int perimeter = method.isTriangle(4,5,6);
        System.out.println(perimeter);
    }


    /**
     * 方法的定义 计算三角形的周长
     * @param a 边长
     * @param b 边长
     * @param c 边长
     * @return 不构成三角形0 构成返回周长
     */
    int isTriangle(int a, int b, int c){
        int perimeter;
        if (a + b > c && a + c > b && b +c > a){
            perimeter = a + b +c;
        }else {
            return 0;
        }
        return perimeter;
    }
}

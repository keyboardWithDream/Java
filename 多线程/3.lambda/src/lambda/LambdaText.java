package lambda;

/**
 * Lambda 推导
 * @Author: Harlan
 * @Date: 2020/6/11 14:42
 */
public class LambdaText {

    public static void main(String[] args) {
        /**
         * lambda推导(必须存在类型)
         */Master i = ()->{
            System.out.println("lambda1..."); };
        //调用
        i.lambda();

        //一行代码 { } 可省略
        new IClass(()->System.out.println("lambda2...")).lambda();
    }

}


/**
 * 接口
 */
interface Master{

    /**
     * 接口方法
     */
    void lambda();
}

/**
 * 实现类
 */
class IClass implements Master{

    public IClass(Master m) {
        m.lambda();
    }

    @Override
    public void lambda() {
        System.out.println("lambda3...");
    }
}

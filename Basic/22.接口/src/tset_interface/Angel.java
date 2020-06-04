package tset_interface;

/**
 * 天使类
 * 实现类
 * 可以实现多个接口
 * @author Harlan
 */
public class Angel implements Volant, Honest{
    @Override
    public void helpOther() {
        System.out.println("天使正在帮助你...");
    }

    @Override
    public void fly() {
        System.out.println("天使正在飞... 最大高度:" + FLY_HEIGHT);
    }

    public static void main(String[] args) {
        Angel angel = new Angel();
        angel.fly();
        angel.helpOther();
    }
}

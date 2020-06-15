package factory_model;

/**
 * @Author: Harlan
 * @Date: 2020/6/15 20:40
 */
public class Apple implements Food{
    @Override
    public void eat() {
        System.out.println("正在吃苹果...");
    }
}

package factory_model;

/**
 * @Author: Harlan
 * @Date: 2020/6/15 20:41
 */
public class Bread implements Food{
    @Override
    public void eat() {
        System.out.println("正在吃面包...");
    }
}

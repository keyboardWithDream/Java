package factory_model;

/**
 * @Author: Harlan
 * @Date: 2020/6/15 20:47
 */
public class Main {

    public static void main(String[] args) {
        Food food = Factory.createFood("Bread");
        food.eat();
    }
}

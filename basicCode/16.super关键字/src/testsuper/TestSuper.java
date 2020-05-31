package testsuper;

/**
 * super 关键字
 * @author Harlan
 */
public class TestSuper {
    public static void main(String[] args) {
        Child child = new Child();
        child.getValue();
    }
}

class Father{
    public int value;

    public Father() {
        System.out.println("父类构造方法被执行...");
    }

    public void getValue(){
        this.value = 100;
        System.out.println("Father value = "+value);
    }
}

class Child extends Father{
    public int value;

    /**
     *构造方法默认第一句是super();
     */
    public Child() {
        System.out.println("子类构造方法被执行...");
    }

    @Override
    public void getValue() {
        //调用父类对象的普通方法
        super.getValue();

        value = 200;
        System.out.println("Child value = "+ value);

        super.value = 300;
        System.out.println("Father value = "+super.value);
    }
}

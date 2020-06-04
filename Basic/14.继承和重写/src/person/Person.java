package person;

/**
 * Person 父类
 * @author Harlan
 */
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
    }

    protected void Person() {
    }

    protected void Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void print(){
        System.out.println("姓名: "+ name +" 年龄: "+age);
    }
}

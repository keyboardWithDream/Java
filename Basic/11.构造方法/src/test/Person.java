package test;

/**
 * @Author: Harlan
 * @Date: 2020/6/14 20:36
 */
public class Person {
    private String name;
    private String addr;
    private char sex;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String addr, char sex, int age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

     public void print(){
        System.out.println(name+"-"+addr+"-"+sex+"-"+age);
    }
}

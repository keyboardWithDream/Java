package test;

/**
 * @Author: Harlan
 * @Date: 2020/6/14 23:04
 */
public class Student extends Person{
    private String name;
    private String addr;
    private char sex = 'M';
    private int age;
    private int math;
    private int english;

    public Student() {
    }

    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public Student(String name, String addr, char sex, int age, int math, int english) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
        this.math = math;
        this.english = english;
    }

    @Override
    public void print() {
        System.out.println(name+"-"+addr+"-"+sex+"-"+age+"-"+math+"-"+english);
    }

    public String see() {
        return "Student{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", math=" + math +
                ", english=" + english +
                '}';
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    public static void main(String[] args) {
        Student stu = new Student("1","2",'F',3,4,5);
        Person per = new Student("1","2",'F',3,4,5);
        stu.print();
        stu.see();
    }
}

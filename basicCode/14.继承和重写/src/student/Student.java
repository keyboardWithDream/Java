package student;

import person.Person;

/**
 * @author Harlan
 * 继承父类
 * 继承只有单继承
 */
public class Student extends Person {
    String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("专业: " + major);
    }

    public static void main(String[] args) {
        Student stu = new Student("Harlan", 23, "Computer");
        stu.print();
        //instanceof 判断对象是否属于类
        System.out.println(stu instanceof Student);
        System.out.println(stu instanceof Person);
    }
}

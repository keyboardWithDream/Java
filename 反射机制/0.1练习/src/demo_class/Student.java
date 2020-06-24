package demo_class;

/**
 * @Author: Harlan
 * @Date: 2020/6/24 10:56
 */
public class Student extends Person {

    private int id;

    public Student() {
    }


    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void study(){
        System.out.println(super.getName() + "正在学习...");
    }
}

package demo_class;

/**
 * @Author: Harlan
 * @Date: 2020/6/24 11:02
 */
public class Teacher extends Person{

    private int id;

    public Teacher() {
    }

    public Teacher(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void teach(){
        System.out.println(super.getName() + "正在教学...");
    }
}

package orm;

/**
 * @Author: Harlan
 * @Date: 2020/6/22 11:51
 */

@StuTable("tb_student")
public class Student {

    @StuField(columnName = "id", type = "int", length = 10)
    private int id;
    @StuField(columnName = "sname", type = "varchar", length = 10)
    private String studentName;
    @StuField(columnName = "age", type = "int", length = 3)
    private int age;

    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

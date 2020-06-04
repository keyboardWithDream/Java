package array;

/**
 * 数组:
 * 数组定义: type[] arr_name; 或  type arr_name[];
 * @author Harlan
 */
public class Arr {
    public static void main(String[] args) {
        //静态初始化数组
        int[] arrInt = { 1, 3, 4, 5, 6, 7, 8, 9, 0};

        //默认初始化数组
        String[] arrStr = new String[10];
        for (String s : arrStr) {
            System.out.println(s);
        }

        System.out.println("=========================");

        //动态初始化数组
        User[] arrUser = new User[2];
        arrUser[0] = new User(01,"Harlan");
        arrUser[1] = new User(02,"Abby");
        for (int i = 0; i < arrUser.length; i++) {
            System.out.println(arrUser[i].getId() +" " + arrUser[i].getName());
        }
    }
}


class User{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

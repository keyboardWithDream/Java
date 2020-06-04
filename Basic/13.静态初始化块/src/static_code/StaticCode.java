package static_code;

/**
 * 静态初始化块
 */
public class StaticCode {
    int id;
    String name;
    static String pwd;

    //静态初始化块
    static {
        System.out.println("正在初始化StatiCode类...");
        pwd = "123456";
        System.out.println("密码默认为: " + pwd);
    }

    /**
     * 构造方法
     * @param id id
     * @param name name
     */
    public StaticCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo(){
        System.out.println(id + " " + name + " " + pwd);
    }

    public static void main(String[] args) {
        StaticCode staticCode = new StaticCode(1000, "harlan");
        staticCode.printInfo();
    }
}

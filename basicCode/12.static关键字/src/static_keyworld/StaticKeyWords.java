package static_keyworld;

/**
 * 在类中,用static声明的成员变量为静态成员变量,也称为类变量.生命周期和类相同.
 * static 修饰的成员变量和方法,从属于类.普通变量和方法从属于对象.
 */
public class StaticKeyWords {
    int id;
    String name;
    static String pwd = "004460";

    public StaticKeyWords(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void printInfo(){
        System.out.println(id + name + pwd);
    }

    public static void main(String[] args) {
        StaticKeyWords staticKeyWords = new StaticKeyWords(1000,"harlan");
        staticKeyWords.printInfo();
    }
}

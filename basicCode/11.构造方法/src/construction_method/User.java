package construction_method;

public class User {
    int id;
    String name;
    String pwd;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public void printUsr(){
        System.out.println("id: "+ id + ", name: " + name + ", password: " + pwd);
    }

    public static void main(String[] args) {
        User harlan = new User(1000, "harlan", "004460");
        harlan.printUsr();
    }
}

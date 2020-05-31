package object_equals;

/**
 * equals 判断是否相同
 * @author Harlan
 */
public class TestEquals {
    public static void main(String[] args) {
        User user1 = new User(12345,"harlan", 23);
        User user2 = new User(12345,"abby", 27);
        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));
    }
}

class User{
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //重写equals判断id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User)obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}

package tcp_multiple_login;

import java.io.Serializable;

/**
 * 用户类
 * @Author: Harlan
 * @Date: 2020/6/18 15:43
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

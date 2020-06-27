package login;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Author: Harlan
 * @Date: 2020/6/27 20:40
 */
public class Login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = sc.nextLine();
        System.out.print("请输入密码: ");
        String password = sc.nextLine();
        if (login(username,password)){
            System.out.println("登陆成功...");
        }else {
            System.out.println("登陆失败...");
        }

    }


    public static boolean login(String username, String password){
        String sql = "SELECT * FROM users WHERE username = \"" + username + "\"AND password = \""+password+"\"";
        Connection conn = JDBCUtils.connect();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,stmt,rs);
        }
        return false;
    }
}

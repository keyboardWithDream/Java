package jdbc;

import user.User;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Harlan
 * @Date: 2020/6/27 15:58
 */
public class LearnResultSet {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";
        String user = "root";
        String pwd = "Hhn004460";
        String sql = "SELECT * FROM emp";
        List<User> userList = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            userList = createUser(rs);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            release(conn,stmt,rs);
        }

        for (User u : userList) {
            System.out.println(u.toString());
        }
    }

    private static List<User> createUser(ResultSet rs){
        List<User> userList = new ArrayList<>();
        while (true){
            try {
                if (rs.next()){
                    userList.add(new User(rs.getInt("empNo"),rs.getString("ENAME"),rs.getString("JOB"),rs.getInt("MGR"),rs.getDate("HIREDATE"),rs.getInt("SAL"),rs.getInt("COMM"),rs.getInt("deptNO")));
                }else {
                    break;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userList;
    }

    private static void release(Connection conn, Statement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (stmt != null){
            try {
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

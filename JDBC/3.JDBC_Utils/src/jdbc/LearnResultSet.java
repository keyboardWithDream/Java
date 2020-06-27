package jdbc;

import jdbc_utils.JDBCUtils;
import user.User;

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

        String sql = "SELECT * FROM emp";
        List<User> userList = null;

        try {
            conn = JDBCUtils.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            userList = createUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,stmt,rs);
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
}

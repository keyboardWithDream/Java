package exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改记录 db_test数据库
 * @Author: Harlan
 * @Date: 2020/6/27 14:12
 */
public class Exercise2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";
        String user = "root";
        String pwd = "Hhn004460";
        String sql = "update emp set job=\"CLERK\" where empNo=7839";

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if (count > 0){
                System.out.println("sql执行成功, 影响了: "+count+"行..." );
            }else {
                System.out.println("sql执行失败...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null){
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
}

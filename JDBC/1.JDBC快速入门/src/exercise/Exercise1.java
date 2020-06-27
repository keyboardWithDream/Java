package exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习增删查改 db_test数据库:
 * 1.emp 表添加一条数据
 * @Author: Harlan
 * @Date: 2020/6/27 13:33
 */
public class Exercise1 {

    /**
     * 定义sql,连接信息
     */
    static final String SQL = "insert into emp values (4460,\"HARLAN\",\"PRESIDENT\",NULL,\"1997-11-17\",100000,NULL,10)";
    static final String URL = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";
    static final String USER = "root";
    static final String PWD = "Hhn004460";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3.获取Connection连接对象
            conn = DriverManager.getConnection(URL,USER,PWD);
            //4.获取sql执行对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(SQL);
            if (count > 0){
                System.out.println("sql成功执行!-影响了: "+count+"行...");
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

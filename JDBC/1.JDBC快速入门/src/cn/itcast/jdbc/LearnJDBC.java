package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 * @Author: Harlan
 * @Date: 2020/6/27 11:30
 */
public class LearnJDBC {

    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包

        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取数据库连接对象 url+?serverTimezone=UTC
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?serverTimezone=UTC", "root", "Hhn004460");

        //4.定义SQL语句
        String sql = "UPDATE emp SET MGR = 7760 WHERE empNO = 7839";

        //5.执行SQL的对象 Statement
        Statement stmt = conn.createStatement();

        //6.执行SQL语句
        int count = stmt.executeUpdate(sql);

        //7.处理结果
        System.out.println(count);

        //8.释放资源
        stmt.close();
        conn.close();
    }
}

package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * @Author: Harlan
 * @Date: 2020/6/27 19:20
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //读取资源文件,获取值
    static {
        //1.创建Properties集合类
        Properties pro = new Properties();
        //2.加载文件
        //获取src路径下的文件方式Class.loader
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL resource =classLoader.getResource("jdbc.properties");
        String path = resource.getPath();
        try {
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return 连接对象
     */
    public static Connection connect(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    /**
     * 释放资源
     * @param conn 连接对象
     * @param stmt 执行对象
     */
    public static void close(Connection conn, Statement stmt) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        close(conn, stmt);
    }
}

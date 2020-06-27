package cn.itcast.jdbc;

import javax.xml.crypto.Data;
import java.sql.*;

/**
 * @Author: Harlan
 * @Date: 2020/6/27 14:58
 */
public class LearnResultSet {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_test?serverTimezone=UTC";
        String user = "root";
        String pwd = "Hhn004460";
        String sql = "SELECT * FROM emp";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();
            //获取结果
            rs = stmt.executeQuery(sql);
            printData(rs);
//            //获取第一行数据
//            //1.让游标向下移动一行
//            rs.next();
//            //2.获取数据
//            int empNo = rs.getInt(1);
//            String eName = rs.getString(2);
//            String job = rs.getString(3);
//            Date date = rs.getDate("HIREDATE");
//            int sal = rs.getInt("SAL");
//            int deptNo = rs.getInt("deptNO");
//            //3.打印数据
//            System.out.println(empNo+"-->"+eName+"-->"+job+"-->"+date+"-->"+sal+"-->"+deptNo);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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

    /**
     * 打印结果
     * @param rs 结果
     */
    private static void printData(ResultSet rs){
        while (true){
            try{
                //判断游标是否是最后一行末尾
                if (!rs.next()){
                    break;
                }else {
                    int empNo = rs.getInt(1);
                    String eName = rs.getString(2);
                    String job = rs.getString(3);
                    Date date = rs.getDate("HIREDATE");
                    int sal = rs.getInt("SAL");
                    int deptNo = rs.getInt("deptNO");
                    System.out.println(empNo+"-->"+eName+"-->"+job+"-->"+date+"-->"+sal+"-->"+deptNo);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println();
        }
    }
}

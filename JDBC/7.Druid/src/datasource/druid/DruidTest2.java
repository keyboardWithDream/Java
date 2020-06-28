package datasource.druid;

import datasource.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用工具类
 * @Author: Harlan
 * @Date: 2020/6/28 13:52
 */
public class DruidTest2 {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pStmt = null;
        String sql = "INSERT INTO account VALUES(NULL, ?,?)";

        try {
            conn = JDBCUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,"赵六");
            pStmt.setInt(2,1000);
            int count = pStmt.executeUpdate();
            if (count > 0){
                System.out.println("sql执行成功! 影响: "+count+"行数据...");
            }else {
                System.out.println("sql执行失败...");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pStmt);
        }
    }
}

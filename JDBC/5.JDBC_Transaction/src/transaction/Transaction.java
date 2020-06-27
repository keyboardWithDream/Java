package transaction;

import u.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 * @Author: Harlan
 * @Date: 2020/6/27 22:10
 */
public class Transaction {

    public static void main(String[] args) {

        String sqlSub = "UPDATE account SET balance = balance - ? WHERE id = ?";
        String sqlAdd = "UPDATE account SET balance = balance + ? WHERE id = ?";
        Connection conn = JDBCUtils.connect();
        PreparedStatement pStmtAdd = null;
        PreparedStatement pStmtSub = null;

        try {
            //手动提交事务
            conn.setAutoCommit(false);

            pStmtAdd = conn.prepareStatement(sqlAdd);
            pStmtSub = conn.prepareStatement(sqlSub);
            //设置参数
            pStmtAdd.setDouble(1,500);
            pStmtAdd.setInt(2,1);

            pStmtSub.setDouble(1,500);
            pStmtSub.setInt(2,2);

            //执行
            pStmtAdd.executeUpdate();

            //手动制造异常
            int i = 3 / 0;

            pStmtSub.executeUpdate();

            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            try {
                //事务回滚
                if (conn != null){
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pStmtAdd);
            JDBCUtils.close(null,pStmtSub);
        }
    }
}

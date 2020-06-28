package datasource.c3p0.test1;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.log.Log;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0测试1
 * @Author: Harlan
 * @Date: 2020/6/28 10:45
 */
public class C3P0Test1 {

    public static void main(String[] args) {
        //1.创建数据库连接对象
        DataSource ds = new ComboPooledDataSource();

        //2.获取连接对象
        Connection conn = null;
        try {
            conn = ds.getConnection();

            //3.打印
            System.out.println(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

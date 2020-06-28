package datasource.c3p0.test1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0测试2
 * @Author: Harlan
 * @Date: 2020/6/28 11:13
 */
public class C3P0Test2 {

    public static void main(String[] args) {
        //使用默认配置
        DataSource ds = new ComboPooledDataSource();
        Connection conn = null;
        //指定名称配置 - 参数
        DataSource dsMysql = new ComboPooledDataSource("mysql");
        Connection connMysql = null;

        //获取11个默认连接对象
        for (int i = 1; i <= 11; i++) {
            try {
                conn = ds.getConnection();
                System.out.println(i+" : " +conn);

                //第五次归还连接
                if (i == 5){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        System.out.println("==========指定名称对象获取==============");

        //获取9个指定名称连接对象
        for (int i = 1; i <= 9; i++) {
            try {
                connMysql = dsMysql.getConnection();
                System.out.println(i+" : " +connMysql);

                //第五次归还连接
                if (i == 5){
                    connMysql.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

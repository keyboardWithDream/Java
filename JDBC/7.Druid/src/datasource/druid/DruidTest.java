package datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid测试
 * @Author: Harlan
 * @Date: 2020/6/28 12:28
 */
public class DruidTest {

    public static void main(String[] args) {
        //1.导入jar包 get
        //2.定义配置文件 get
        //3.加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
            //4.获取连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            //5.获取连接
            Connection conn = ds.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

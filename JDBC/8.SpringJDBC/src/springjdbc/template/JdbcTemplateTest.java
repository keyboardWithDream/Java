package springjdbc.template;

import org.springframework.jdbc.core.JdbcTemplate;
import jdbc_utils.JDBCUtils;


/**
 * --数据库jdbc--
 * JdbcTemplate入门
 * @Author: Harlan
 * @Date: 2020/6/28 14:53
 */
public class JdbcTemplateTest {
    //1.导入jar包

    public static void main(String[] args) {

        String sql = "UPDATE account SET balance = 3000 WHERE id = ?";

        //2. 创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        int count = template.update(sql,3);
        System.out.println(count);
    }
}

package exercise;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import jdbc_utils.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * --数据库 db_test--
 * 1.修改 empNO 7369 的 MGR 为 4460
 * 2.添加一条记录到 empNO
 * 3.删除刚刚添加的记录
 * 4.查询empNO 为4460 的记录,封装为map集合
 * 5.查询所有记录,封装为List
 * 6.查询所有记录,封装为Emp对象的List 集合
 * 7.查询总记录数
 * @Author: Harlan
 * @Date: 2020/6/28 18:15
 */
public class Exercise {

    static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        String sql1 = "UPDATE emp SET MGR = 4460 WHERE empNO = 7369";
        String sql2 = "INSERT INTO emp VALUES(1234,\"JACK\",\"SALESMAN\",4460,\"2020-06-28\",4000,NULL,30)";
        String sql3 = "DELETE FROM emp WHERE empNO = 1234";
        String sql4 = "SELECT * FROM emp WHERE empNO = 4460";
        String sql5 = "SELECT * FROM emp";
        String sql6 = "SELECT * FROM emp";
        String sql7 = "SELECT COUNT(empNo) FROM emp";

        Map<String, Object> map = resultSetMap(sql4);
        System.out.println(map);

        List<Map<String, Object>> list = resultSetList(sql5);
        System.out.println(list);

        List<Emp> empList = getEmpList(sql6);
        for (Emp emp : empList) {
            System.out.println(emp);
        }

        int count = count(sql7);
        System.out.println(count);
    }

    /**
     * 1-3练习
     * @param sql 语句
     */
    private static void executeSql(String sql){
        int count = template.update(sql);
        if (count > 0){
            System.out.println("sql 执行成功! 影响了: "+ count+"行...");
        }else {
            System.out.println("sql 执行失败...");
        }
    }

    /**
     * 练习4
     * @param sql 语句
     * @return 查询集合
     */
    private static Map<String, Object> resultSetMap(String sql){
        return template.queryForMap(sql);
    }


    /**
     * 练习5
     * @param slq 语句
     * @return List
     */
    private static List<Map<String, Object>> resultSetList(String slq){
        return template.queryForList(slq);
    }


    /**
     * 练习6
     * @param sql 语句
     * @return list<Emp>
     */
    private static List<Emp> getEmpList(String sql) {
        return template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
    }

    /**
     * 练习7
     * @param sql 语句
     * @return 数量
     */
    private static int count(String sql){
        return template.queryForObject(sql,int.class);
    }
}

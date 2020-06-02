package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Data类的常见用法
 * DataFormat抽象类和 SimpleDataFormat实现类的使用
 * @Author: Harlan
 * @Date: 2020/6/2 15:18
 */
public class TestDate {

    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        Date d2 = new Date(99999);
        System.out.println(d1);

        /* 获得毫秒数 可以比较时间先后 */
        System.out.println(d1.getTime());
        System.out.println(d1.after(d2));
        System.out.println(d1.before(d2));

        /* 转成字符串 */
        String date = d1.toString();
        System.out.println(date);

        /* 转成格式的字符串 */
        /* 时间对象和字符串之间的相互转化 */
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日'-'HH:mm:ss");
        date = df.format(d1);
        System.out.println(date);

        //字符串转时间
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日'-'HH:mm:ss");
        Date date1 = df2.parse("2020年06月02日-15:43:54");
        System.out.println(date1);
    }
}

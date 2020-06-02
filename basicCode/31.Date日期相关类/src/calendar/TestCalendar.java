package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 日期类的使用
 * @Author: Harlan
 * @Date: 2020/6/2 15:49
 */
public class TestCalendar {

    public static void main(String[] args) {
        /* 获得日期的相关元素 */
        Calendar calendar = new GregorianCalendar(1997,11,17,11,13,43);
        int year = calendar.get(Calendar.YEAR);
        /* 0-11表示对应的月份,0 是 1月 */
        int month = calendar.get(Calendar.MONTH);
        /* 星期几 1-7, 1 是 星期日 */
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        /* 几号 */
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+" "+month+" "+weekday+" "+day);
        System.out.println(calendar);

        System.out.println("========================");

        //设置日期的相关元素
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR,2020);
        c.set(Calendar.MONTH,6);
        c.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(c);

        System.out.println("========================");

        //日期的计算
        Calendar c1 = new GregorianCalendar();
        /* 往后一百天 */
        c1.add(Calendar.DAY_OF_YEAR,100);
        System.out.println(c1);
    }
}

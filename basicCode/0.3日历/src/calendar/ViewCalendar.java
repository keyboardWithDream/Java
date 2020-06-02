package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历
 * @Author: Harlan
 * @Date: 2020/6/2 16:26
 */
public class ViewCalendar {

    public static void main(String[] args) throws ParseException {
        String strDate;
        System.out.println("请输入查询的日期(YYYY-MM-DD):");
        Scanner scanner = new Scanner(System.in);
        strDate = scanner.nextLine();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);


        int itsDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(itsDay);
        /* startDayOfWeek 为第星期几开始, 1-7 */
        int startDayOfWeek = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1).get(Calendar.DAY_OF_WEEK);
        System.out.println(startDayOfWeek);
        /* dayOfMonth 为一个月多少天 加上打印空格的次数,作为循环条件 */
        int dayOfMonth = calendar.getActualMaximum(Calendar.DATE) + startDayOfWeek;
        System.out.println(dayOfMonth);
        /* 从1号开始打印 */
        int days = 1;

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for (int i = 1; i < dayOfMonth; i++) {
            if (i  < startDayOfWeek){
                System.out.print(" \t");
            }else if (i % 7 == 0 ){
                if (days == itsDay){
                    System.out.println("*"+days);
                }else {
                    System.out.println(days);
                }
                days++;
            }else {
                if (days == itsDay){
                    System.out.print("*"+days+"  ");
                }else {
                    System.out.print(days + "\t");
                }
                days++;
            }
        }
    }
}

package stop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 * @Author: Harlan
 * @Date: 2020/6/11 19:05
 */
public class Countdown {

    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 10 * 1000);
        long end = endTime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("yyyy-MM-dd'-'HH:mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime() - 1000);
            if (end - 1000 * 10 > endTime.getTime()){
                break;
            }
        }
    }
}


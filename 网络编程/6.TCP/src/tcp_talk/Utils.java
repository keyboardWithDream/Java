package tcp_talk;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author: Harlan
 * @Date: 2020/6/18 20:13
 */
public class Utils {
    
    public static void close(Closeable... targets){
        for (Closeable target : targets) {
            try {
                if (target != null){
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

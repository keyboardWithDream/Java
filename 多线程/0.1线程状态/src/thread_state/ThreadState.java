package thread_state;

/**
 * 观察线程的状态
 * @Author: Harlan
 * @Date: 2020/6/11 21:02
 */
public class ThreadState {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
            }
        });

        //观察状态(NEW)
        Thread.State state = t.getState();
        System.out.println(state);

        //RUNNABLE
        t.start();
        state = t.getState();
        System.out.println(state);

        //TIMED_WAITING
        while (true){
            int num = Thread.activeCount();
            if (num == 2){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程执行完毕TERMINATED

            state = t.getState();
            System.out.println(state);
        }
    }
}

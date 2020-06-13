package quartz;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * quartz 学习入门
 */
public class Quartz {

  public void run() throws Exception {

    // 1.创建 Scheduler 工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    // 2.从工厂中获取调度器
    Scheduler sched = sf.getScheduler();

    System.out.println("初始化完毕...");

    // 时间
    Date runTime = evenSecondDateAfterNow();

    // 3.创建JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

    // 4.触发条件
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // 5.注册任务和触发条件
    sched.scheduleJob(job, trigger);

    // 6.启动
    sched.start();


    try {
      // 10 秒后停止
      Thread.sleep(10L * 1000L);
      // executing...
    } catch (Exception e) {

    }
  }

  public static void main(String[] args) throws Exception {
    Quartz example = new Quartz();
    example.run();
  }

}

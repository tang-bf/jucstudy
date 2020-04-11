package com.yss;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: DemoSynchronizedAnalyze
 * @Description: jconsole, jstack
 * @Author: tbf
 * @CreateDate: 2020-04-11 16:35
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 16:35
 * @UpdateRemark:
 * @Version: 1.0
 */

public class DemoSynchronizedAnalyze {
    private final  static  Object LOCK = new Object();
    public static void main(String[] args) {
        Runnable runnable = ()->{
            /**
             * "Thread-2" #14 prio=5 os_prio=0 tid=0x000000001afff000 nid=0x4e74 waiting on condition [0x000000001ba3f000]
             *    java.lang.Thread.State: TIMED_WAITING (sleeping)
             *         at java.lang.Thread.sleep(Native Method)
             *         at com.yss.DemoSynchronizedAnalyze.lambda$main$0(DemoSynchronizedAnalyze.java:24)
             *         - locked <0x00000000d612d638> (a java.lang.Object)
             *         at com.yss.DemoSynchronizedAnalyze$$Lambda$1/930990596.run(Unknown Source)
             *         at java.lang.Thread.run(Thread.java:748)
             *
             * "Thread-1" #13 prio=5 os_prio=0 tid=0x000000001b020800 nid=0x1aac waiting for monitor entry [0x000000001b93f000]
             *    java.lang.Thread.State: BLOCKED (on object monitor)
             *         at com.yss.DemoSynchronizedAnalyze.lambda$main$0(DemoSynchronizedAnalyze.java:24)
             *         - waiting to lock <0x00000000d612d638> (a java.lang.Object)
             *         at com.yss.DemoSynchronizedAnalyze$$Lambda$1/930990596.run(Unknown Source)
             *         at java.lang.Thread.run(Thread.java:748)
             *
             * "Thread-0" #12 prio=5 os_prio=0 tid=0x000000001b01d800 nid=0x50bc waiting for monitor entry [0x000000001b83e000]
             *    java.lang.Thread.State: BLOCKED (on object monitor)
             *         at com.yss.DemoSynchronizedAnalyze.lambda$main$0(DemoSynchronizedAnalyze.java:24)
             *         - waiting to lock <0x00000000d612d638> (a java.lang.Object)
             *         at com.yss.DemoSynchronizedAnalyze$$Lambda$1/930990596.run(Unknown Source)
             *         at java.lang.Thread.run(Thread.java:748)
             */
            //monitorenter monitorexit goto
            synchronized (LOCK){
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}

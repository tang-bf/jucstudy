package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: StopThreadGraceful
 * @Description: 优雅的停止线程方法 标志开关 ;interrupt
 * @Author: tbf
 * @CreateDate: 2020-04-11 14:35
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 14:35
 * @UpdateRemark:
 * @Version: 1.0
 */

public class StopThreadGraceful {
    private static class Worker extends Thread {
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {

            }
        }

        public void shutDown() {
            this.start = false;
        }
    }

    private static class Worker2 extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break;//不建议return 保证后面的do other something
                }
            }
            ///do other something
        }
    }

    public static void main(String[] args) {
       /* Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutDown();
        System.out.println("shutDown");*/
        Worker2 worker2 = new Worker2();
        worker2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker2.interrupt();
        System.out.println("By worker2 shutDown");
    }
}

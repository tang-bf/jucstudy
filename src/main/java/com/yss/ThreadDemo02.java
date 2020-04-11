package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: ThreadDemo02
 * @Description: thread study
 * @Author: tbf
 * @CreateDate: 2020-04-11 13:32
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 13:32
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ThreadDemo02 {
    private static final Object object = new Object();

    public static void main(String[] args) {
        /*Thread t = new Thread(()->{
            while (true){
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.interrupted());
                    }
                }
            }
        });
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());*/
        /**
         * * <p> If this thread is blocked in an invocation of the {@link
         *      * Object#wait() wait()}, {@link Object#wait(long) wait(long)}, or {@link
         *      * Object#wait(long, int) wait(long, int)} methods of the {@link Object}
         *      * class, or of the {@link #join()}, {@link #join(long)}, {@link
         *      * #join(long, int)}, {@link #sleep(long)}, or {@link #sleep(long, int)},
         *      * methods of this class, then its interrupt status will be cleared and it
         *      * will receive an {@link InterruptedException}.
         */
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("mmmmmm");
            }
            main.interrupt();
           // t.interrupt();
            /**
             * wait sleep 的都是当前t线程，然后用t.interrupt是可以打断的
             * 但是join的时候是join main线程，打断的是t线程
             */
            //   此时不会被打断,由于join 是main线程
            System.out.println("dddd");
        });
        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("ttttt");
        }

    }

}

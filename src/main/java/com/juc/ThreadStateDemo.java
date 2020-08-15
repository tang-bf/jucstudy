package com.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: ThreadStateDemo
 * @Description: 线程运行状态，操作系统层面和java  API 层面
 * @Author: tbf
 * @CreateDate: 2020-04-12 21:48
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-12 21:48
 * @UpdateRemark:
 * @Version: 1.0
 */
@Slf4j
/**
 * 操作系统层面五种状态 new  runnable running blocked (bio操作阻塞)terminated
 * java api 层面  new  runnable(包含了操作系统层面的runnable running blocked ) blocked waiting(join ) timed_waiting(sleep ) terminated
 */
public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("running......");
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t2.start();
        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                log.debug("running......");
            }
        };
        t3.start();
        Thread t4 = new Thread("t4") {
            @Override
            public void run() {
                synchronized (ThreadStateDemo.class) {
                    try {
                        Thread.sleep(1_000_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();
        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();
        Thread t6= new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadStateDemo.class) {
                    try {
                        Thread.sleep(1_000_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1>>>>" + t1.getState());
        System.out.println("t2>>>>" + t2.getState());
        System.out.println("t3>>>>" + t3.getState());
        System.out.println("t4>>>>" + t4.getState());
        System.out.println("t5>>>>" + t5.getState());
        System.out.println("t6>>>>" + t6.getState());


    }
}

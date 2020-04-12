package com.juc;


import java.util.stream.Stream;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: ProducerCousumerVersion1
 * @Description: 线程间的通信，生产者消费者模式
 * @Author: tbf
 * @CreateDate: 2020-04-11 21:55
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 21:55
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ProducerCousumerVersion1 {
    private int i=10;
    private volatile boolean isProduced = false;
    private final static Object o = new Object();

    public void produce() {
        synchronized (o) {
           // if (isProduced) {
            while  (isProduced) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            } //else {
                i++;
                System.out.println("P>>>>" + i);
                o.notifyAll();
                isProduced=true;
           // }
        }
    }

    public void consumer() {
        synchronized (o) {
            //if (isProduced) {
            while  (isProduced) {
                System.out.println("C>>>>" + i);
                isProduced=false;
                o.notifyAll();
            }//else{
                try {
                    o.wait();

                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            //}

        }
    }

    public static void main(String[] args) {
        ProducerCousumerVersion1 producerCousumerVersion1 = new ProducerCousumerVersion1();
        Stream.of("p1","p2","p3","p4","p5","p6").forEach(n->{
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        producerCousumerVersion1.produce();
                    }

                }
            }.start();
        });
        /*new Thread("producer1") {
            @Override
            public void run() {
                while (true) {
                    producerCousumerVersion1.produce();
                }

            }
        }.start();
        new Thread("producer2") {
            @Override
            public void run() {
                while (true) {
                    producerCousumerVersion1.produce();
                }

            }
        }.start();*/
        Stream.of("c1","c2","c3","c4","c6").forEach(n->{
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        producerCousumerVersion1.consumer();
                    }

                }
            }.start();
        });
        /*new Thread("consumer1") {
            @Override
            public void run() {
                while (true) {
                    producerCousumerVersion1.consumer();
                }

            }
        }.start();
        new Thread("consumer2") {
            @Override
            public void run() {
                while (true) {
                    producerCousumerVersion1.consumer();
                }

            }
        }.start();*/
    }
}

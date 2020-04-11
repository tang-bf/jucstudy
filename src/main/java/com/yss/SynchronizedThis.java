package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: SynchronizedThis
 * @Description: synchronized  this锁的存在
 * @Author: tbf
 * @CreateDate: 2020-04-11 17:43
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 17:43
 * @UpdateRemark:
 * @Version: 1.0
 */

public class SynchronizedThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1") {
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();
        new Thread("T2") {
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }

    static class ThisLock {
        private final Object object = new Object();

        public synchronized void m1() {
            System.out.println("m1>>>>" + Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* public synchronized   void m2(){
             System.out.println("m2>>>>"+Thread.currentThread().getName());
             try {
                 Thread.sleep(10_000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }*/
        public void m2() {
            synchronized (object) {
                System.out.println("m2>>>>" + Thread.currentThread().getName());
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

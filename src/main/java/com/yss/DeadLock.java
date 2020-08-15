package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: DeadLock
 * @Description: 死锁
 * @Author: tbf
 * @CreateDate: 2020-04-11 18:10
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 18:10
 * @UpdateRemark:
 * @Version: 1.0
 */

public class DeadLock {
    private  static  final  Object o1 = new Object();
    private  static  final  Object o2 = new Object();
    public static void main(String[] args) {
            new Thread("t1"){
                @Override
                public void run() {
                    m1();
                }
            }.start();
        new Thread("t2"){
            @Override
            public void run() {
                m2();
            }
        }.start();
    }
    public  static  void  m1(){
        synchronized (o1) {
            System.out.println("m1>>>>>");
            m2();
        }
    }
    public  static  void  m2(){
        synchronized (o2){

        System.out.println("m2>>>>>");
        m1();
        }
    }
}

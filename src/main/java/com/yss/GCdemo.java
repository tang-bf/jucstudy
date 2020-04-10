package com.yss;

public class GCdemo {
    public static void main(String[] args) {
        // allocate 4M space
        byte[] a = new byte[4 * 1024 * 1024];
        System.out.println("first allocate");
        // allocate 4M space
         a = new byte [4 * 1024 * 1024];
        System.out.println("second allocate");
        Thread thread  = new Thread("custom"){
            @Override
            public void run() {
                /* super.run(); */
                for(int i=0;i<9;i++){
                    System.out.println("i>>>"+i);
                }
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread.start();
        Thread thread1 = new Thread(()->{
            System.out.println("nnnnn"+Thread.currentThread().getName());
        });
        thread1.start();
        for(int k=0;k<9; k++){
            System.out.println("k>>"+k);
        }
        /*try {
            Thread.sleep(3000*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(thread.getName());
    }

}

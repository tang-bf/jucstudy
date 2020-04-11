package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: StopThreadGraceful
 * @Description: 优雅的停止线程方法 标志开关
 * @Author: tbf
 * @CreateDate: 2020-04-11 14:35
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 14:35
 * @UpdateRemark:
 * @Version: 1.0
 */

public class StopThreadGraceful {
    private  static class  Worker extends Thread{
        private  volatile  boolean start= true;
        @Override
        public void run() {
            while (start){

            }
        }
        public  void  shutDown(){
            this.start=false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutDown();
        System.out.println("shutDown");
    }
}

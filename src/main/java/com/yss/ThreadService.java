package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: ThreadService
 * @Description: 暴力结束线程
 * @Author: tbf
 * @CreateDate: 2020-04-11 15:11
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 15:11
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ThreadService {
    private Thread execThread;
    private boolean finished = false;

    public void execute(Runnable task) {
        execThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    finished=true;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        };
        execThread.start();
    }
    public  void shutDown(long   mills){
        long  currentMills = System.currentTimeMillis();
        while (!finished){
            if(System.currentTimeMillis()-currentMills>=mills){
                System.out.println("任务超时，要结束");
                execThread.interrupt();
                break;
            }
            try {
                execThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程");
                e.printStackTrace();
                break;
            }
        }
        finished=true;

    }
}
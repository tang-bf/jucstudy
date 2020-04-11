package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: ThreadServiceTest
 * @Description: test暴力停止
 * @Author: tbf
 * @CreateDate: 2020-04-11 15:30
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 15:30
 * @UpdateRemark:
 * @Version: 1.0
 */

public class ThreadServiceTest {
    public static void main(String[] args) {
        ThreadService service  = new ThreadService();
        Long start  = System.currentTimeMillis();
        service.execute(()->{
           /* while (true){
                ///模拟加载很耗时的资源操作
            }*/
           // System.out.println("任务很快结束");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutDown(1000);
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

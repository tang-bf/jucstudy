package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: ThreadTest01
 * @Description: threadTest
 * @Author: tbf
 * @CreateDate: 2020-04-12 17:11
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-12 17:11
 * @UpdateRemark:
 * @Version: 1.0
 */
@Slf4j
public class ThreadTest01 {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        test1();
        log.info("最后结果为：{}" + i);
    }

    public static void test1() throws InterruptedException {
        Thread t = new Thread(() -> {

            try {
                // Thread.sleep(10);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = 10;
        });
        t.start();
        t.join();
        //t.sleep(100);
        log.debug(">>>>" + i);
        log.debug("结束》》》》》");
    }

}

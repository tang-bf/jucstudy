package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: FutureTaskTest
 * @Description: FutureTask ,Callable
 * @Author: tbf
 * @CreateDate: 2020-04-12 14:35
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-12 14:35
 * @UpdateRemark:
 * @Version: 1.0
 */
@Slf4j
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("running.....");
                Thread.sleep(10_000);
                return 100;
            }
        });
        Thread thread  = new Thread(futureTask,"t1");
        thread.start();
        try {
            log.debug("{}",futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}



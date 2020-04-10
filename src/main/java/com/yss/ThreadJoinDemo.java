package com.yss;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: ThreadJoinDemo
 * @Description: java类作用描述
 * @Author: 汤本辉
 * @CreateDate: 2020-04-11 3:02
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 3:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t =  new Thread(()->{
            IntStream.range(1,1_000).forEach(i-> System.out.println(Thread.currentThread().getName()+">>>>"+i));
        });
        Thread t2 =  new Thread(()->{
            IntStream.range(1,1_000).forEach(i-> System.out.println(Thread.currentThread().getName()+">>>>"+i));
        });
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
            // t 和t2交替执行  join只是针对当前main线程,main线程会等到t,t2都执行完
            Optional.of("All done").ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.range(1,1_000).forEach(i-> System.out.println(Thread.currentThread().getName()+">>>>"+i));*/
        Thread.currentThread().join();//一直运行下去
    }
}

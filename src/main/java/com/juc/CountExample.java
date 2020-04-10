
package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
@Slf4j
public class CountExample {
    public  static  int count =0;
    public  final  static  int threadNum=200;//模拟同一时间200个用户发起请求；
    public  final static  int  clientNum=5000;//模拟一共收到500个请求
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        for(int index=0;index<clientNum;index++){
            exec.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    log.error("exception",e);
                }
            });

        }
        exec.shutdown();
        log.info("count:{}",count);
    }
    /*
    *每个线程执行count++
    * */

    /**
     *
     */
    public  static  void add(){
        count++;
    }
}

package com.yss;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName: demo01
 * @Package: action.controller
 * @ClassName: ThreadSourceDemo
 * @Description: java类作用描述
 * @Author: 汤本辉
 * @CreateDate: 2020-04-11 0:13
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 0:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class ThreadSourceDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        /*ThreadGroup  线程组 树形结构，可以包含线程，也可以包含线程组，
        允许线程访问关于其线程组的信息，但不允许访问关于其线程组的父线程组或任何其他线程组的信息
        线程可以访问线程组的信息，
        但是不能访问其他线程组的信息，
        也不能访问父线程的信息*/
        //把线程放到线程组的方法是new Thread(参数)
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
        Arrays.asList(threads).forEach(i-> System.out.println(i));
        System.out.println("----------华丽分割线----------");
        /*
        *通过线程组模拟实现线程池
        * group中的线程并没有因为线程池启动了这个线程任务而运行起来.
        * 因此通过线程组来对线程池中的线层任务分组不可行.
         * */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        final ThreadGroup  group = new ThreadGroup("Main_Group");
        for(int i=0;i<5;i++){
            Thread t = new Thread(group,()->{
                int sleep = (int)(Math.random() * 10);
                try {
                    Thread.sleep(1000 * 3);
                    System.out.println(Thread.currentThread().getName()+"执行完毕");
                    System.out.println("当前线程组中的运行线程数"+group.activeCount());//会一直是0
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },group.getName()+"$$"+i+"");
            executor.execute(t);
        }
    }

}

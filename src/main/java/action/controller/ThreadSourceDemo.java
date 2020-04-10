package action.controller;

import java.util.Arrays;

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
    }
}

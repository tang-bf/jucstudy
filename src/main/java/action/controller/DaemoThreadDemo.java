package action.controller;

import java.util.Optional;

/**
 * @ProjectName: demo01
 * @Package: action.controller
 * @ClassName: DemoThreadDemo
 * @Description: java类作用描述
 * @Author: 汤本辉
 * @CreateDate: 2020-04-11 1:59
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 1:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

public class DaemoThreadDemo {
    /* t线程在非守护线程时候
    *通过jconsole 可以看出，main线程结束后，thread-0线程还在执行，
    * 由于同属一个线程组中还有active线程，或者jvisualvm看到还有Monitor Ctrl-Break  Finalizer 等等
    * 如果t线程设置为daemon，则main结束，t也将消失
    * */
    /*public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(
                ()->{
                    try {
                        System.out.println(Thread.currentThread().getName()+"running");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        t.setDaemon(true);//b必须在启动前设置 否则报Exception in thread "Thread-0" java.lang.IllegalThreadStateException
        t.start();
        Thread.sleep(10_000);//jdk1.7的写法
        System.out.println(Thread.currentThread().getName());
    }*/
    public static void main(String[] args) {
        Thread t = new Thread( ()->{
                Thread innerThread = new Thread(()->{
                    try {
                        while (true){
                            System.out.println("inner running ");
                            Thread.sleep(1_000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                innerThread.setDaemon(true);
                innerThread.start();
            try {
                Thread.sleep(10_000);
                System.out.println("T thread done ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        );
        //t.setDaemon(true);
        t.start();
        t.setPriority(Thread.MAX_PRIORITY);
        Optional.of("hello").ifPresent(System.out::println);
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        //System.out.println(t.getId()+"\n"+t.getPriority()+"\n"+t.getContextClassLoader());
    }

}

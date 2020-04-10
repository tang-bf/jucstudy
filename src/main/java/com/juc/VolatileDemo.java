package com.juc;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class VolatileDemo {

    public static  volatile  Boolean flag =false;
    public  static  void refesh(){
        log.info("fresh  data ......");
        flag = true;
        log.info("fresh  data  success......");
    }
    public   static  void loadData(){
        while (!flag){

        }
        log.info("线程" +Thread.currentThread().getName()+"当前线程嗅探到flag的状态的改变");
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>");

        Thread threadc =  new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                }
        );

        Thread threadA =  new Thread(() ->{
            loadData();
        },"threadA");
        threadA.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread threadB =  new Thread(() ->{
           refesh();
        },"threadB");
        threadB.start();
    }

}

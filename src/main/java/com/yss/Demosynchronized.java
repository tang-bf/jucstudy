package com.yss;


/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: Demosynchronized
 * @Description: synchronized 分析
 * @Author: tbf
 * @CreateDate: 2020-04-11 16:07
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 16:07
 * @UpdateRemark:
 * @Version: 1.0
 */

public class Demosynchronized extends  Thread{
    private  int index = 1;
    private static final  int MAXNUM = 50;
    private  final  Object object= new Object();
    @Override
    public void run() {
        while (true){
            synchronized (object){
            if(index>MAXNUM){
            break;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //synchronized (object){

            System.out.println(Thread.currentThread()+"当前号码》》》"+index++);
            }
        }
    }
}

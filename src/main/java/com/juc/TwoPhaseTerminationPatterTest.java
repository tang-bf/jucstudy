package com.juc;

import com.yss.ThreadService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: TwoPhaseTerminationPatter
 * @Description: Two-Phase Termination Patter 两阶段终止模式
 * 一个线程t1如何优雅的终止t2
 * @Author: tbf
 * @CreateDate: 2020-04-12 18:22
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-12 18:22
 * @UpdateRemark:
 * @Version: 1.0
 */
@Slf4j
public class TwoPhaseTerminationPatterTest {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTerminationPatter twoPhaseTerminationPatter = new TwoPhaseTerminationPatter();
        twoPhaseTerminationPatter.start();

        Thread.sleep(3500);
        twoPhaseTerminationPatter.shutDown();

    }
    static class TwoPhaseTerminationPatter {
        private Thread moniotr;
        public  void start(){
            moniotr = new Thread(()->{
                    while (true){
                        Thread currentThread = Thread.currentThread();
                        if(currentThread.isInterrupted()){
                            log.debug("处理后事....");
                            break;
                        }
                        try {
                            Thread.sleep(100);
                            log.debug("do something....");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            currentThread.interrupt();
                        }
                    }
            });
            moniotr.start();

        }
        public  void shutDown(){
            moniotr.interrupt();
        }
    }
}

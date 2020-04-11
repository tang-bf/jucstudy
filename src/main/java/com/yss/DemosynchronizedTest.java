package com.yss;

/**
 * @ProjectName: demo01
 * @Package: com.yss
 * @ClassName: DemosynchronizedTest
 * @Description: synchronized
 * @Author: tbf
 * @CreateDate: 2020-04-11 16:11
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-11 16:11
 * @UpdateRemark:
 * @Version: 1.0
 */

public class DemosynchronizedTest {
    public static void main(String[] args) {
        final  Demosynchronized demosynchronized = new Demosynchronized();
        Thread d1 = new Thread(demosynchronized,"窗口1");
        Thread d2 = new Thread(demosynchronized,"窗口2");
        Thread d3 = new Thread(demosynchronized,"窗口3");
        Thread d4 = new Thread(demosynchronized,"窗口4");
        d1.start();
        d2.start();
        d3.start();
        d4.start();

    }
}

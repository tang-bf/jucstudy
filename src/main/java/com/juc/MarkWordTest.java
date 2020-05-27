package com.juc;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @ProjectName: demo01
 * @Package: com.juc
 * @ClassName: MarkWordTest
 * @Description: 依赖 jol-core包查看对象头
 * @Author: tbf
 * @CreateDate: 2020-04-13 22:07
 * @UpdateUser: Administrator
 * @UpdateDate: 2020-04-13 22:07
 * @UpdateRemark:
 * @Version: 1.0
 */

public class MarkWordTest {
    public static void main(String[] args) {
        /**
         * 对象创建时，偏向锁默认是开启的，那么Mark word 后三位应该是101 ，
         * 这时thread epoch age 均为0；
         * 偏向锁默认延迟加载的，可-XX:BiasedLockingStartupDelay=0禁用
         * 如果禁止开启，那么mark word 为001 ，这时hashcode age =0;hashcode 第一次使用时才会赋值
         * markword 8zijie   klass pointer 未开启指针压缩也是8字节
         *  java   -XX:+PrintFlagsFinal
         *  java -XX:+PrintCommandLinesFlag
         * -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
         *
         */
        Dog dog = new Dog();
        ClassLayout.parseInstance(dog).toPrintable();//对象内部信息
        System.out.println(">>>>>>>>>");
        System.out.println(ClassLayout.parseInstance(dog).toPrintable());//001
        System.out.println(">>>>>>>>>调用hashcode之后");
        System.out.println(dog.hashCode());
        System.out.println(ClassLayout.parseInstance(dog).toPrintable());//001
        System.out.println(">>>>>>>>>");
        System.out.println( GraphLayout.parseInstance(dog).toPrintable());//对象外部信息,包括引用的对象
        System.out.println(">>>>>>>>>");
        System.out.println(GraphLayout.parseInstance(dog).totalSize());//查看对象占用空间总大小
        System.out.println(">>>>>>>>>");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ClassLayout.parseInstance(new Dog()).toPrintable());//101
        System.out.println(">>>>>>>>>二次调用hashcode之后");
        System.out.println(new Dog().hashCode());
        System.out.println(ClassLayout.parseInstance(new Dog()).toPrintable());//101
    }
    static class Dog{

    }
}

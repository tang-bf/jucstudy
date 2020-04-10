package com.yss;

public class Test {
    public static  final  String str = "abc";
    static String name ;
    /**
     * javac会收集所有类变量赋值动作，或者静态代码块中语句合并而来，jclasslib 看字节码文件才会有clinit方法
     */

    static {
         num = 7;
        System.out.println("先执行》》》");
        //System.out.println(num);  非法向前引用
        /**
         * 成员变量a如果满足如下的4点，就必须在使用前必须对该成员变量进行声明
         *
         *
         * 设定Test为直接包含该成员变量的类或者接口
         * 如果i出现在在Test的或静态成员/非静态成员初始化 或者 Test的静态或非静态代码块中
         * 如果i不是 一个赋值不等式的左值
         * 通过简单名称来访问
         * 在我自己写的代码中，a.printA() ;出现的位置是Test的静态代码块中，通过简单名称直接访问(也就是直接使用a)， 并且不是赋值不等式的左值，所以会报错“非法的前向引用”
         */
    }
    {
        System.out.println("hou 执行》》》");
    }
    static int num  =1;  //在linking阶段的prepare阶段就已经为类变量分配内存应设置默认初始值 ，灵值

    public static void main(String[] args) {
        int a=1;
        int b =3;
        int c = a+b;
        System.out.println("hello"+c);
        System.out.println(">>>>>>"+num);
    }
}

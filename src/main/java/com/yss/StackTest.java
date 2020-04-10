package com.yss;

import java.util.Date;

public class StackTest {
    static  int num= 1;
    int kk;
    public static void main(String[] args) {
        //System.out.println(num);
       // num++;//11417
        int k = 9;
        //this.kk++;因为当前方法局部变量表中不存在this
       // main(args);
       System.out.println(num);
    }

    public   int  add(){
        int mm = 90;
        int  ff ;
        return  kk++;
        //相当于this.kk++;  this 也是变量，存在局部变量表中的index为0的slot中
    }
    public  Boolean  max(Date date ,Long age ){
       // date = null;
       age = 8L;
       Long ll = 99L;
       String str = "kkkk";
        double d = 20.00;
        int aa =88;
        return false;
    }
}

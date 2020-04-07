package action.controller;

public class LVSlot {
    public void method1(){
        byte[] a=new byte[5*1024*1024];
        a=null;
        System.gc();
    }

    public void method2(){
        {
            byte[] a=new byte[5*1024*1024];
            System.out.println(a.length);
        }
        System.gc();
    }

    public void method3(){
        {
            byte[] a=new byte[5*1024*1024];
            System.out.println(a.length);
        }
        int b=0;
        System.gc();
    }

    public static void main(String[] args) {
        LVSlot lv = new LVSlot();
        lv.method1();
//        lv.method2();
//        lv.method3();
        lv.addTest();
    }

    public void  addTest(){
        int i=10;
        i++;//iinc 1 by 1
        int p=10;
        ++p;//iinc 2 by 1
        System.out.println("i>>"+i);//11
        System.out.println("p>>"+p);//11
        int i3=10;
        int i4=i3++;// iload_3
        System.out.println("i3>>"+i3);//11
        System.out.println("i4>>"+i4);//10
        int i5=10;
        int i6=++i5;//iinc 5 by 1
        System.out.println("i6>>"+i6);//11
        int i7=10;
        i7=i7++;// iload 7
        System.out.println("i7>>"+i7);//10
        int i8=10;
        i8=++i8;//iinc 8 by 1
        System.out.println("i8>>"+i8);//11
        int i9=10;
        int i10 = i9++ + ++i9;
        // iload 9   iinc 9 by 1  iinc 9 by 1
        // iload 9  iadd  istore 10
        System.out.println("i10>>"+i10);//22

    }
}

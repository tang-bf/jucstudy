package action.controller;

public class GCdemo {
    public static void main(String[] args) {
        // allocate 4M space
        byte[] a = new byte[4 * 1024 * 1024];
        System.out.println("first allocate");
        // allocate 4M space
         a = new byte [4 * 1024 * 1024];
        System.out.println("second allocate");
    }

}

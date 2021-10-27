package xyz.mosss.spring.examples.springboot.a.b;

public class Test1 {
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }


    public static void main(String[] args) {
        System.out.println(reverse(-2147483647));
    }
}
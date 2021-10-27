package xyz.mosss.spring.examples.springboot.a;

public class S extends P {
    static{
        System.out.println("S is init");
    }
    public static void main(String[] args) {
        System.out.println(S.abc);
    }
}

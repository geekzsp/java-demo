package xyz.mosss.spring.examples.springboot.a.d;

public class Bean2 {
    public static String b = "2";


    static {
        System.out.println("bean2 外部测试");
    }

    static class Bean2Helper {
        static Bean2 bean2 = new Bean2();

        static {
            System.out.println("bean2测试");
            System.out.println(bean2);
        }
    }

    public static Bean2 getInstance() {
        return Bean2Helper.bean2;
    }
}
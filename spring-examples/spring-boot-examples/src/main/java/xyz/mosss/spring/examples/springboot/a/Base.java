package xyz.mosss.spring.examples.springboot.a;

public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    class Sub extends Base {
        private String baseName = "sub";

        @Override
        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Sub b = new Base().new Sub();
    }
}
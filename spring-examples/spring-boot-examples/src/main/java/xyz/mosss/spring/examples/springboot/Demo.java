package xyz.mosss.spring.examples.springboot;

/**
 * @author moss
 * @date 2020/6/1
 */
public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("test");
            System.out.println(i);
        }
        Person person = new Person(21);
        System.out.println(person);
        person.setAge(23);
        person.getAge();
        String a = test();
        System.out.println(person.getAge());
        Object o = null;
         o.toString();
    }

    private static String test() {
        String a = "a";
        a = a + 1 + 2;
        a = 1 + 2 + a;
        return a;
    }
}
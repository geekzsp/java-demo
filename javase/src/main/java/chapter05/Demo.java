package chapter05;

/**
 * Description:
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/13
 *
 * @author 张士鹏
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person();
        Person.test();
        String[] names = {"张三", "李四", "王五"};
        for (String name : names) {
            System.out.println(name);
        }
        test1(names);
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(""+test2(10));
    }

    /**
     * 参数可变的方法
     */
    private static void test1(String... names) {
        names[1] = "fsasdf";
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 已知有一个数列：f(0)=1,f(1)=4,f(n+2)=2*f(n+1)+f(n);
     * 求f（10）
     * @param n
     * @return
     */
    private static int test2(int n) {
        int x = n - 2;
        if (x == 0) {
            return 1;
        } else if (x == 1) {
            return 4;
        } else {
            return 2 * test2(x + 1) + test2(x);
        }
    }
}

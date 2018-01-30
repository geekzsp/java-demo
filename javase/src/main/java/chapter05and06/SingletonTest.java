package chapter05and06;

/**
 * Description:
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/15
 * author：		张士鹏
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1==singleton2);
    }
}

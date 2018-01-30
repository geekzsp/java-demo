package chapter05and06;

/**
 * Description:
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/15
 * author：		张士鹏
 */
public class Compare {
    public static void main(String[] args) {
        System.out.println(new Integer(2).equals(new Integer(2)));
        System.out.println(new Integer(2) == new Integer(2));
        Integer i1 = 2;
        Integer i2 = 2;//这是因为 Integer自动装箱的时候 有一个缓冲数组 包-128~127缓冲起来了。
        System.out.println(i1 == i2);
        System.out.println(Integer.compare(2, 4));
        char a = 'a';
        char b = 'a';
        System.out.println(a == b);
        char c= 97;
        System.out.println(c);
        System.out.println((int)c);
        System.out.println(c+1);
        System.out.println("hello"=="hello");
        System.out.println(new String("hello").equals(new String("hello")));
        System.out.println(new String("hello")==new String("hello"));
    }
}

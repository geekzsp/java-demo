package chapter05;

import java.awt.*;

/**
 * Description:方法参数传递
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/13
 *
 * @author 张士鹏
 */
public class PrimitiveTransferTest {
    public static void temp(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("函数中a=" + a + "b=" + b);
    }

    public static void main(String[] args) {
        int a = 6, b = 9;
        System.out.println("交换前a=" + a + "b=" + b);
        temp(6,9);
        System.out.println("交换后a=" + a + "b=" + b);
    }
}

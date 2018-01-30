package chapter04;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Description: 数组Demo
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/11
 *
 * @author 张士鹏
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //数组的定义 +静态初始化 可省略new
        int[] arrs1 = new int[]{1, 3, 4, 6, 2};
        System.out.println(Arrays.toString(arrs1));
        int[] arrs2 = {1, 3, 4, 6};
        System.out.println(Arrays.toString(arrs2));
        //数组的定义 +动态初始化
        String[] arrs3 = new String[4];
        System.out.println(Arrays.toString(arrs3));
        //二维数组
        int[][] values1 = new int[4][3];
        for (int[] ints : values1) {
            for (int anInt : ints) {
                System.out.print(anInt + "");
            }
            System.out.println("");
        }
        //Arrays工具类
        Arrays.sort(arrs1);//排序
        System.out.println(Arrays.toString(arrs1));
        int i = Arrays.binarySearch(arrs1, 3);//二分法查找 要求必须升序 返回位置从0开始，不包含则返回负数
        System.out.println(i);
        int[] ints = Arrays.copyOf(arrs1, 7);//复制
        System.out.println(Arrays.toString(ints));
        Arrays.equals(arrs1, arrs2);//长度 和内容相同返回true
        Arrays.fill(arrs1, 99);//全部填充
        System.out.println(Arrays.toString(arrs1));
        int[] sarr1 = {1, 3, 5, 7};
        int[] sarr2 = {2, 4, 6, 8};
        System.arraycopy(sarr1, 3, sarr2, 0, 1);
        System.out.println(Arrays.toString(sarr2));
        Arrays.parallelSort(sarr2);//并行 排序
        //打印圆
        int radius = 5;
        for (int x = 1; x <= 2 * radius; x++) {
            for (int y = 1; y <= 2 * radius; y++) {
                if(Math.pow(x-radius,2)+Math.pow(y-radius,2)==Math.pow(radius,2)){
                    System.out.print("*");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.print("\n");
        }
    }
}

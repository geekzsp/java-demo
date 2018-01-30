package chapter07;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Description:键盘输入程序
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/16
 * author：		张士鹏
 */
public class ScannerDemo {

    public static void main(String[] args) {
        //FileInputStream fileInputStream=new FileInputStream(new File("/data/a.txt"));
        //String a;
        //System.out.println(a);
        Scanner sc = new Scanner(System.in);
        //增加下面一行只把回车作为分隔符
        //sc.useDelimiter("\n");
        //判断是否还有下一个输入项
        while (sc.hasNext()) {
            System.out.println("键盘输入的内容：" + sc.next());
        }

    }
}

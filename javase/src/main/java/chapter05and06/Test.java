package chapter05and06;
import  static  java.lang.Math.*;
import  static  java.lang.System.*;
/**
 * Description: 成员变量 未初始化
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/13
 * author：		张士鹏
 */
public class Test {
    String str;
    int a;
    char b;
    short s;
    float f;
    long lo;
    double dou;
    byte e;
    boolean flag;
    Object obj;
    public static void main(String[] args){
        Test ts = new Test();
        ts.print();
        //静态导入
        double sqrt = sqrt(256);
        out.print(sqrt);
        out.print(PI);
    }



    public void print(){
        System.out.println("str:"+str+"\n"+"a:"+a+"\n"+"b:"+b+"\n"+"s:"+s+"\n"+"f:"+f+"\n"+"lo:"+lo+"\n"+"dou:"+dou
                + "\n"+"e:"+e+"\n"+"flag:"+flag+"\n"+"obj:"+obj+"\n");
    }
    {
         int aa=1;
        System.out.println(a);
    }

}

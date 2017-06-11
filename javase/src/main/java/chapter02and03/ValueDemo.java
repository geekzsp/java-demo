package chapter02and03;

import java.util.Random;

/**
 * Description:
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/11
 *
 * @author 张士鹏
 */
public class ValueDemo {
    public static void main(String[] args) {
        //十进制
        //二进制  默认占32位  0B或者0b开头 （java7新增)              8 4 2 1
        int binVal1 = 0b00001111;
        System.out.println(binVal1);
        byte binVal2 = (byte) 0b11101001;
        /*
        *  原码 1 1 1 0 1 0 0 1
        *  反码 1 0 0 1 0 1 1 0
        *  补码 1 0 0 1 0 1 1 1 =-23
        * */
        System.out.println(binVal2);
        //Java7 数值中可以使用下划线
        System.out.println(113_123_534);
        //八进制   0开头
        //十六进制 0X 或者0x开头

        char cha1='a';
        char cha2='\n';
        char cha3='\u7ECF';
        char cha4=97;//如果把一个范围在0~65535的整数赋给char类型变量，系统会自动把这个int整数当成char类型来处理
        int cc='a';
        System.out.println(cha1);
        System.out.println(cha2);
        System.out.println(cha3);
        System.out.println(cha3+0);
        System.out.println((char)32463);
        System.out.println(cha4);
        System.out.println('a'+97);
        System.out.println(cc);
        //for (int i=0;i<=65535;i++){
        //    System.out.print("   编号："+i+" 字符："+(char)i);
        //    if(i%100==0){
        //        System.out.println("");
        //    }
        //}
        float fVla=5.2345556f;
        System.out.println(fVla);
        System.out.println(3.14e2);
        System.out.println(0.0/0.0); //非数
        System.out.println(213213.13/0);//正无穷
        System.out.println(-213213.13/0);//负无穷
        //System.out.println(123/0);//除0 异常
        boolean boo=false;
        Random random=new Random();
        //利用强制转换生成随机数字
        for(int i=0;i<4;i++) {
            char ranChar = (char) (random.nextInt(20) + 97);
            System.out.print(ranChar);
        }
        System.out.println(19.0/4);
        System.out.println(5/0.0);
        System.out.println(5.0/0);
        System.out.println(5.0%0.0);
        System.out.println(3*Math.pow(2,3));
        System.out.println(3<<3);


    }
}

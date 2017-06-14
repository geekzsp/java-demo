package chapter05;

/**
 * Description: 鸵鸟
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/13
 * author：		张士鹏
 */
public class Ostrich extends Bird {
    @Override
    public void fly() {
        //super.fly();
        System.out.println("我只能在地上奔跑");
    }
    public static void main(String[] args) {
        new Bird().fly();
        new Ostrich().fly();
    }
}

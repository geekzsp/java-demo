package chapter05and06;

/**
 * Description: 鸟类
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/13
 * author：		张士鹏
 */
public class Bird {
    public Bird(){
        System.out.println("父类无参构造器");
    }
    public Bird(int bird){
        System.out.println("有参构造器");
    }
    public void fly() {
        System.out.println("我在天空自由的飞翔");
    }
}

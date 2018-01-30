package chapter05and06;

/**
 * Description: 一个单例类
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/15
 * author：		张士鹏
 */
class Singleton {
    //使用一个类变量来缓存曾经创建过的实例
    private static Singleton singleton;

    //私有化构造器
    private Singleton() {
    }

    /**
     * 提供一个静态方法
     *
     * @return singleton
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

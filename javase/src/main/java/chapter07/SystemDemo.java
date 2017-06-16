package chapter07;

import javax.naming.NamingEnumeration;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Description:System类使用
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/16
 * author：		张士鹏
 */
public class SystemDemo {
    public static void main(String[] args) throws IOException {
        //或者系统所有的环境变量
        Map<String, String> getenv = System.getenv();
        for(String name:getenv.keySet()){
            System.out.println(name+"--->"+getenv.get(name));
        }
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(javaHome);
        //获取系统属性
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("javase/props.txt"),"demo");
        //区别于操作系统 可能不准确
        long l = System.currentTimeMillis();//毫秒
        System.out.println(l);
        long l1 = System.nanoTime();//纳秒
        System.out.println(l1);
        System.identityHashCode(SystemDemo.class);//返回指定对象的hashcode 和重写不关 绝对唯一
    }
}

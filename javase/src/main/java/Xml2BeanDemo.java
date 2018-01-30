import com.thoughtworks.xstream.XStream;
import org.junit.Test;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/12/11 下午7:42
 */
public class Xml2BeanDemo {


    public static void main(String[] args) {
        XStream xStream = new XStream();

        User user = new User();
        user.setAge(23);
        user.setName("张三");
        user.setIdNo("23432432432423");
        xStream.autodetectAnnotations(true);
        String s = xStream.toXML(user);
        System.out.println(s);
    }


}

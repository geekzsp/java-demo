package other;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author zhangshipeng
 * 2019-02-17
 */
public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        byte a = 1;
        byte b = 2;
        //byte c=a+b;
        long d = 100L;
        double e = 3;
        //Double e1 = 3;
        //int f=1.1;

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

    }
}

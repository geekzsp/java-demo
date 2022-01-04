package charset;

import cn.hutool.Hutool;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author zhangshipeng
 * @date 2021/12/30
 */
public class CharSetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "😈123456😈";
        String x = StrUtil.subByCodePoint(str, 1, (int) str.codePoints().count() - 1);
        System.out.println(x);
        System.out.println(str.replace(x,"****"));
        //𡃁
        //tofu
        print("\uD844\uDCC1");
        print("😈");
        print("A");
        print("1");
        print("中");
        Hutool.printAllUtils();
    }

    private static void print(String str) throws UnsupportedEncodingException {
        System.out.println("=======");
        System.out.println(str.codePoints().count());
        System.out.println(str.length());
        System.out.println(str.toCharArray().length);
        System.out.println(str.getBytes("utf-16le").length);
    }
}

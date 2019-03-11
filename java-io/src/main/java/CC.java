import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangshipeng
 * 2019-01-07
 */
public class CC {
    public static void main(String[] args) {

        String s="<p><span style=>各学院中：</span></p><p><span style=>各学院1：</span></p>";

        String regex=">(([^\\x00-\\xff]|[0-9])+?)</span>";

        Pattern p= Pattern.compile(regex);

        Matcher m=p.matcher(s);

        while(m.find()){

            System.out.println(m.group(1));

        }

    }
}

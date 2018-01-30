/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/12/6 下午3:20
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        String s = new ExceptionDemo().exceptinDemo();
        System.out.println(s);
    }


    public String exceptinDemo() {
        String resutlt="";
        try {
            resutlt = "A";
            int a = 1 / 0;

        } catch (Exception e) {
            e.printStackTrace();
            resutlt = "B";
            throw new RuntimeException();
        }finally {
            return resutlt;
        }

    }
}

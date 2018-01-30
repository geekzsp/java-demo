import java.util.Random;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2018/1/19 上午11:50
 */
public class Demo {
    public static void main(String[] args) {
        Random random = new Random(10);
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(10);
            System.out.print(num);
        }
        System.out.println();
        System.out.println(random.nextInt());

        for (int i = 0; i <60 ; i++) {
            int number= random.nextInt(10);
            System.out.print(number+" ");
        }
        System.out.println();
        //相同种子数的Random对象，相同次数生成的随机数字是完全相同的。
        Random r1 = new Random(10);
        Random r2 = new Random(10);
        for(int i = 0;i < 2;i++){
            System.out.println(r1.nextInt());
            System.out.println(r2.nextInt());
        }
    }
}

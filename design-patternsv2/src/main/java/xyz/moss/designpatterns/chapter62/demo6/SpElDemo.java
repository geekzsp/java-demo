package xyz.moss.designpatterns.chapter62.demo6;

import com.google.common.math.DoubleMath;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
public class SpElDemo {
    static class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();

        public BigDecimal rate;

        public Double rate1;
    }

    public static void main(String[] args) {

        Simple simple = new Simple();

        simple.booleanList.add(true);
        simple.rate = BigDecimal.ZERO;
        simple.rate1 = 1.0;

        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);

// false is passed in here as a string. SpEL and the conversion service will
// correctly recognize that it needs to be a Boolean and convert it
        ExpressionParser parser = new SpelExpressionParser();

        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");

        // b will be false
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);

        BigDecimal value = (BigDecimal) parser.parseExpression("rate").getValue(simpleContext);
        System.out.println(value);

        Double value1 = (Double) parser.parseExpression("rate1").getValue(simpleContext);
        System.out.println(value1);

        Boolean value2 = (Boolean) parser.parseExpression("rate1 > 0.06").getValue(simpleContext);
        System.out.println(value2);


        Boolean value3 = (Boolean) parser.parseExpression("rate.compareTo(new java.math.BigDecimal('-5')) >= 0").getValue(simpleContext);
        System.out.println(value3);

        Double value4 = (Double) parser.parseExpression("rate1 - 0.1").getValue(simpleContext);
        System.out.println(value4);

        double a1 = 1.0;
        double b1 = 0.9;
        double c = a1 - b1;
        double d = 0.1;
        System.out.println("-------");
        //System.out.println(c);
        //System.out.println(d);
        //System.out.println(a1-b1);
        System.out.println(c == d);
        BigDecimal g = new BigDecimal(c).setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(g);
        System.out.println(g.doubleValue());
        System.out.println(d == 0.1);
        System.out.println("==========");

        Double aa = 0.1;
        Double bb = 0.1;
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));
        System.out.println(Double.compare(aa, bb));
        System.out.println(aa.compareTo(bb));

        int c1 = 1111;
        int d1 = 1111;
        Integer f1 = 1111;
        Integer g1 = 1111;
        System.out.println(c1 == d1);
        System.out.println(c1 == f1);
        System.out.println(f1 == g1);
        System.out.println(f1.equals(g1));

        System.out.println("+++++++++++++++++");

        double a2 = 0.1;
        double b2 = 0.1;
        double c2 =0.10;
        System.out.println(a2 == b2);
        System.out.println(a2 ==c2);


        System.out.println((1.0-0.9) ==0.1);
        System.out.println(Double.compare((1.0-0.9),0.1));
        System.out.println(DoubleMath.fuzzyEquals((1.0-0.9),0.1,0.01));

        int i =10;
        double j= 10.0;
        if (i==j)
        {
            System.out.println("IT IS TRUE");
        }

        double dd = 3.2;
        float ff = 3.2f;
        double dd1=3.2;
        System.out.println(dd==ff);
        System.out.println(dd==dd1);


        Integer value5 = (Integer) parser.parseExpression("36 / 2").getValue();
        System.out.println(value5);

        Expression expression = parser.parseExpression("1+2");
        Integer value6 = expression.getValue(c, Integer.class);
        System.out.println(value6);

    }
}

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.UUID;

/**
 * 类描述
 *
 * @author zhangshipeng
 * @date 2017/11/23 下午4:35
 */
public class BigDecimalDemo {
    @Test
    public void bigDecimalTest() {
        System.out.println("===========普通===========");
        System.out.println(0.06 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(303.1 / 1000);
        System.out.println("===========精准===========");
        System.out.println(BigDecimal.valueOf(0.06).add(BigDecimal.valueOf(0.01)));
        System.out.println(BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.42)));
        System.out.println(BigDecimal.valueOf(4.015).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(303.1).divide(BigDecimal.valueOf(1000), 4, RoundingMode.UP));
        System.out.println(BigDecimal.valueOf(1.2).max(BigDecimal.valueOf(1.1)));
        System.out.println(new BigDecimal("1.443").intValue());


        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("150.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount)); //贷款金额: ￥150.48
        System.out.println("利率:\t" + percent.format(interestRate));  //利率: 0.8%
        System.out.println("利息:\t" + currency.format(interest)); //利息: ￥1.20

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(UUID.randomUUID());
    }
}

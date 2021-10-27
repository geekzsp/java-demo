package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Getter
@Setter
@SuperBuilder
public class OrderActivity  extends Activity{

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    private BigDecimal shareAmount;



}

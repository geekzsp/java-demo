package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Getter
@Setter
@SuperBuilder
public class CommodityActivity  extends Activity{

    private BigDecimal discountPrice;

    private BigDecimal shareAmount;




}

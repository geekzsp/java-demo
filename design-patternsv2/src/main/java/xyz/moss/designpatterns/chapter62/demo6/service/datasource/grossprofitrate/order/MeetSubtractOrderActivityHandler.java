package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.order;

import org.springframework.stereotype.Service;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.OrderActivity;

import java.math.BigDecimal;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Service
public class MeetSubtractOrderActivityHandler implements OrderActivityHandler {


    /**
     * 最大优惠
     * @param commodityId
     * @param skuId
     */
    @Override
    public OrderActivity getMaximumDiscount(long commodityId, long skuId) {
        return OrderActivity.builder()
                .activityId(1L)
                .activityType(getActivityType())
                .discountAmount(BigDecimal.ZERO)
                .shareAmount(BigDecimal.ZERO)
                .build();
    }

    @Override
    public Integer getActivityType() {
        return null;
    }

    /**
     * 优先级 越小越高
     */
    @Override
    public Integer order() {
        return null;
    }
}

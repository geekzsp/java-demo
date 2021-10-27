package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.order;

import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.ActivityHandler;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.OrderActivity;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
public interface OrderActivityHandler extends ActivityHandler {

    /**
     * 最大优惠
     */
    OrderActivity getMaximumDiscount(long commodityId, long skuId);
}

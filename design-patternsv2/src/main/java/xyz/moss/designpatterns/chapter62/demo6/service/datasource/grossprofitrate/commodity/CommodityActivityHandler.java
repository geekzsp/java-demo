package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.commodity;

import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.ActivityHandler;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.CommodityActivity;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
public interface CommodityActivityHandler extends ActivityHandler {
    CommodityActivity calculateDiscountPrice(long commodityId, long skuId);
}

package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.commodity;

import org.springframework.stereotype.Service;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.CommodityActivity;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Service
public class FlashSaleCommodityActivityHandler implements CommodityActivityHandler {
    @Override
    public CommodityActivity calculateDiscountPrice(long commodityId, long skuId) {
        return null;
    }

    @Override
    public Integer getActivityType() {
        return 0;
    }

    @Override
    public Integer order() {
        return 0;
    }
}

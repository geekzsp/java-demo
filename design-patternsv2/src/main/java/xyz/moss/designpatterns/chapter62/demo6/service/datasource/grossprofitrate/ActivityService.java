package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.commodity.CommodityActivityHandler;
import xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate.order.OrderActivityHandler;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Service
@RequiredArgsConstructor
public class ActivityService {
    private final List<CommodityActivityHandler> commodityActivityHandlerList;
    private final List<OrderActivityHandler> orderActivityHandlers;
    @PostConstruct
    public void init() {
        commodityActivityHandlerList.sort(Comparator.comparing(ActivityHandler::order));
        orderActivityHandlers.sort(Comparator.comparing(ActivityHandler::order));
    }


    public Optional<CommodityActivity> discountPriceOfCommodityActivity(long commodityId, long skuId) {
        for (CommodityActivityHandler commodityActivityHandler : commodityActivityHandlerList) {
            CommodityActivity commodityActivity = commodityActivityHandler.calculateDiscountPrice(commodityId, skuId);
            if (commodityActivity != null) {
                return Optional.of(commodityActivity);
            }
        }
        return Optional.empty();
    }

    public Optional<OrderActivity> maximumDiscountOfOrderActivity(long commodityId, long skuId) {
        for (OrderActivityHandler orderActivityHandler : orderActivityHandlers) {
            OrderActivity maximumDiscount = orderActivityHandler.getMaximumDiscount(commodityId, skuId);
            if (maximumDiscount != null) {
                return Optional.of(maximumDiscount);
            }
        }
        return Optional.empty();
    }
}

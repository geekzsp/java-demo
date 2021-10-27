package xyz.moss.designpatterns.chapter62.demo6.service.datasource.grossprofitrate;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * 毛利率服务
 * @author zhangshipeng
 * @date 2021/2/1
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GrossProfitRateService {
    public static final int SCALE = 4;
    private final ActivityService activityService;

    /**
     * 实时毛利率
     * = 售价-供货价+商品承担金额-订单优惠金额/售价-订单优惠金额
     */
    public BigDecimal currentGrossProfitRate(long commodityId, long skuId) {
        //供货价
        BigDecimal costPrice = BigDecimal.ZERO;
        //实时售价
        BigDecimal discountPrice = BigDecimal.ZERO;
        //商品活动商家承担金额
        BigDecimal commodityShareAmount = BigDecimal.ZERO;
        //订单活动商家承担金额
        BigDecimal orderShareAmount = BigDecimal.ZERO;
        //优惠分摊金额
        BigDecimal discountAmount = BigDecimal.ZERO;
        //单个商品活动价格
        Optional<CommodityActivity> commodityActivityOptional = activityService.discountPriceOfCommodityActivity(commodityId, skuId);
        if (commodityActivityOptional.isPresent()) {
            CommodityActivity commodityActivity = commodityActivityOptional.get();
            discountPrice = commodityActivity.getDiscountPrice();
            commodityShareAmount = commodityActivity.getShareAmount();
        }
        //满减，满折等订单维度活动分摊最大优惠情况
        Optional<OrderActivity> orderActivityOptional = activityService.maximumDiscountOfOrderActivity(commodityId, skuId);
        if (orderActivityOptional.isPresent()) {
            OrderActivity orderActivity = orderActivityOptional.get();
            //订单活动商家承担金额
            orderShareAmount = orderActivity.getShareAmount();
            //优惠分摊金额
            discountAmount = orderActivity.getDiscountAmount();
        }
        //商家承担金额
        BigDecimal shareAmount = commodityShareAmount.add(orderShareAmount);

        //分子：售价-供货价+商品承担金额-订单优惠金额
        BigDecimal numerator = discountPrice.subtract(costPrice).add(shareAmount).subtract(discountAmount);
        //分母： 售价-订单优惠金额
        BigDecimal denominator = discountPrice.subtract(discountAmount);
        BigDecimal grossProfitRate = numerator.divide(denominator, SCALE, BigDecimal.ROUND_HALF_UP);

        log.info("currentGrossProfitRate :skuId:{},discountPrice,{},commodityActivity:{},orderActivity:{}",
                skuId,
                discountPrice,
                JSON.toJSONString(commodityActivityOptional),
                JSON.toJSONString(orderActivityOptional));

        return grossProfitRate;
    }
}

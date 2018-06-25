package com.zsp.design.patterns.demo9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  分店
 * @author: zhangshipeng
 * 2018/6/13
 */
public class MarketBranch extends Market {

    List<Market> marketList = new ArrayList<>();

    public MarketBranch(String name) {
        this.name = name;
    }

    @Override
    public void add(Market market) {
        marketList.add(market);

    }

    @Override
    public void remove(Market market) {
        marketList.remove(market);
    }

    @Override
    public void payByCard() {
        // 消费之后，该分店下的加盟店自动累加积分
        System.out.println(name + "消费,积分已累加入该会员卡");
        for (Market m : marketList) {
            m.payByCard();
        }
    }
}

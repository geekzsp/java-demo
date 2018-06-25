package com.zsp.design.patterns.demo9;

/**
 * @author: zhangshipeng
 * 2018/6/13
 */
public class MarketJoin extends Market {
    public MarketJoin(String s) {
        this.name = s;

    }

    @Override
    public void add(Market market) {

    }

    @Override
    public void remove(Market market) {

    }

    @Override
    public void payByCard() {
        // TODO Auto-generated method stub
        System.out.println(name + "消费,积分已累加入该会员卡");
    }
}

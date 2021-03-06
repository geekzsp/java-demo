package com.zsp.design.patterns.demo9;

/**
 * 组合模式
 * 发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，
 * 统一地使用组合结构中的所有对象时，就应该考虑组合模式了
 *
 * @author: zhangshipeng
 * 2018/6/13
 */
public class Client {
    public static void main(String[] args) {

        MarketBranch rootBranch = new MarketBranch("总店");
        MarketBranch qhdBranch = new MarketBranch("秦皇岛分店");
        MarketJoin hgqJoin = new MarketJoin("秦皇岛分店一海港区加盟店");
        MarketJoin btlJoin = new MarketJoin("秦皇岛分店二白塔岭加盟店");

        qhdBranch.add(hgqJoin);
        qhdBranch.add(btlJoin);
        rootBranch.add(qhdBranch);
        rootBranch.payByCard();
    }
}

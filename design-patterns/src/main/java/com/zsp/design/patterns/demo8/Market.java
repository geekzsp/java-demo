package com.zsp.design.patterns.demo8;

/**
 * @author: zhangshipeng
 * 2018/6/13
 */
public abstract class Market {
     String name;

    public abstract void add(Market market);

    public abstract void remove(Market market);

    public abstract void payByCard();
}

package com.zsp.design.patterns.demo5;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ConcretePrototype2 implements Prototype {
    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象
     */
    @Override
    public Object clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}

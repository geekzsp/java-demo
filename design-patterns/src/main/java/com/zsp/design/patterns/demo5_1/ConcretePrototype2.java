package com.zsp.design.patterns.demo5_1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ConcretePrototype2 implements Prototype {
    private String name;
    @Override
    public Prototype clone(){
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }
    @Override
    public String toString(){
        return "Now in Prototype2 , name = " + this.name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

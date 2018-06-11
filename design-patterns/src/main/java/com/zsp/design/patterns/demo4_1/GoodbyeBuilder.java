package com.zsp.design.patterns.demo4_1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class GoodbyeBuilder extends Builder {
    public GoodbyeBuilder() {
        msg = new GoodbyeMessage();
    }

    /**
     * 标题零件的建造方法
     */
    @Override
    public void buildSubject() {
       msg.setBody("欢送内容");
    }

    /**
     * 内容零件的建造方法
     */
    @Override
    public void buildBody() {
        msg.setSubject("欢送标题");
    }
}

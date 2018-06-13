package com.zsp.design.patterns.demo7_1;

/**
 * 适配器模式：对象适配器
 * 我手中有个ps2插头的设备，但是主机上只有usb插头的插口，怎么办呢？弄个转换器，将ps2插头转换成为USB插头就可以使用了。
 * <p>
 * 　　接口Ps2：描述ps2接口格式
 * <p>
 * 　　接口Usb：描述USB接口格式
 * <p>
 * 　　类Usber：是接口Usb的实现类，是具体的USB接口格式
 * <p>
 * 　　Adapter：用于将ps2接口格式转换成为USB接口格式
 *
 * @author: zhangshipeng
 * 2018/6/12
 */
public class Client {
    public static void main(String[] args) {
        Ps2 ps2 = new Adapter(new Usber());
        ps2.isPs2();
    }
}

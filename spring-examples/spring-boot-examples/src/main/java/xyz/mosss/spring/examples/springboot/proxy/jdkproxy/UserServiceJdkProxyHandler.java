package xyz.mosss.spring.examples.springboot.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceJdkProxyHandler implements InvocationHandler {
    private Object object;

    public UserServiceJdkProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理执行前");
        Object invoke = method.invoke(object, args);
        System.out.println("jdk代理执行后");
        return invoke;
    }
}
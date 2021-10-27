package xyz.mosss.spring.examples.springboot.proxy.cglibproxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceCglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理执行前");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib代理执行后");
        return o1;
    }
}
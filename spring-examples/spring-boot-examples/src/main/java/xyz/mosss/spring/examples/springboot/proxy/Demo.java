package xyz.mosss.spring.examples.springboot.proxy;

import net.sf.cglib.proxy.Enhancer;
import xyz.mosss.spring.examples.springboot.proxy.cglibproxy.UserServiceCglibProxy;
import xyz.mosss.spring.examples.springboot.proxy.jdkproxy.UserServiceJdkProxyHandler;
import xyz.mosss.spring.examples.springboot.proxy.staticproxy.UserServiceStaticProxy;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        //静态代理
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy = new UserServiceStaticProxy(userService);
        userServiceProxy.getUser();
        //jdk 代理
        UserServiceJdkProxyHandler userServiceJdkProxyHandler = new UserServiceJdkProxyHandler(userService);
        UserService jdkProxyUserService = (UserService) Proxy.newProxyInstance(Demo.class.getClassLoader(), userService.getClass().getInterfaces(), userServiceJdkProxyHandler);
        jdkProxyUserService.getUser();
        //cglib代理
        UserServiceCglibProxy cglibProxy = new UserServiceCglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(cglibProxy);
        enhancer.setSuperclass(userService.getClass());
        UserService cgLibProxyUserService = (UserService) enhancer.create();
        cgLibProxyUserService.getUser();

    }
}
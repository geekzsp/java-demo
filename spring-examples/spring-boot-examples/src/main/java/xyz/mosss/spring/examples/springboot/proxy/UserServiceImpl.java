package xyz.mosss.spring.examples.springboot.proxy;

import xyz.mosss.spring.examples.springboot.proxy.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void getUser() {
        System.out.println("原生userService");
    }
}
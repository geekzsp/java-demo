package xyz.mosss.spring.examples.springboot.proxy;

public interface UserService {

    void getUser();

    default void getUser1() {
        System.out.println("default getUser1");
    }
}

package xyz.mosss.spring.examples.springboot.a.d;

public class B extends A {
    @Override
    public synchronized void me() {
        super.me();
    }
}
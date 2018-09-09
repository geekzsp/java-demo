package com.zsp.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
class Dog {
    /**
     * name
     */
    private String name = "哮天犬";
    /**
     * 默认10斤狗粮
     */
    private int food = 10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    /**
     * 吃狗粮
     *
     * @param num
     * @return 还剩多少斤
     */
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Test6 {
    public static void main(String[] args) {
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("接收的数据");
        //静态的方法引用
        //Consumer<Dog> consumer1 = dog -> Dog.bark(dog);
        Consumer<Dog> consumer1 = Dog::bark;
        Dog dog = new Dog();
        consumer1.accept(dog);
        //非静态方法的方法引用
        //Function<Integer, Integer> function = i->dog.eat(i);
        Function<Integer, Integer> function = dog::eat;
        System.out.println("还剩下" + function.apply(2) + "斤");
        //使用类名来方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还剩下" + eatFunction.apply(dog, 2) + "斤");
        //构造函数的方法引用
        //Supplier<Dog> supplier = () -> new Dog();
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创造了个新对象" + supplier.get());
        //带参数的构造函数的方法引用
        Function<String, Dog> function1 = Dog::new;
        System.out.println("创造了个新对象" + function1.apply("旺财"));
    }
}

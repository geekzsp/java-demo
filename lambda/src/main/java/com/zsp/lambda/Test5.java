package com.zsp.lambda;

import java.text.DecimalFormat;
import java.util.function.*;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
public class Test5 {
    static class Money {
        int money;

        public Money(int money) {
            this.money = money;
        }

        public void printMoney(Function<Integer, String> function) {
            System.out.println("我的钱" + function.apply(money));
        }
    }

    public static void main(String[] args) {
        Money money = new Money(99999999);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        money.printMoney(integerStringFunction.andThen(i -> "  人民币  " + i));

        //断言函数
        Predicate<Integer> predicate = i -> i > 2;
        System.out.println(predicate.test(6));
        IntPredicate intPredicate = i -> i > 2;
        System.out.println(intPredicate.test(2));
        //消费函数
        //Consumer<Integer> consumer = s -> System.out.println(s);
        Consumer<Integer> consumer = System.out::println;
        consumer.andThen(System.err::println).accept(100);
        System.out.println("----------");
        Consumer<Integer> consumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        Consumer<Integer> consumer2 = consumer1.andThen(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.err.println(integer);
            }
        });
        consumer2.accept(100);
        System.out.println("-----------");
        //生产函数
        Supplier<String> supplier = () -> "1000";
        System.out.println(supplier.get());
    }
}


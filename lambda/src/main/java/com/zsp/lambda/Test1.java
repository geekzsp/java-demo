package com.zsp.lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: zhangshipeng
 * 2018/9/5
 */
public class Test1 {
    public static void main(String[] args) {
        String[] nameArr = {"aaa", "vvv", "efe"};
        List<String> nameList = Arrays.asList(nameArr);
        //方式一
        Iterator<String> iterator = nameList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        for (Iterator iterator2 = nameList.iterator(); iterator2.hasNext(); ) {
            System.out.println(iterator2.next());
        }
        //方式二
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
        //方式三
        for (String s : nameList) {
            System.out.println(s);
        }
        //方式四
        nameList.forEach((name) -> System.out.println(name));
        //方式五
        nameList.forEach(System.out::println);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        }).start();


        new Thread(() -> System.out.println("")).start();
    }
}

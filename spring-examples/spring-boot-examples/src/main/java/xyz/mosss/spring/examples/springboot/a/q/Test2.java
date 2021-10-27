package xyz.mosss.spring.examples.springboot.a.q;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            strings.add("a"+i);
        }
        //strings.remove(1);
        //strings.remove("a");
        //for (String string : strings) {
        //    strings.remove("a");
        //}
        for (int i = 10; i >=0; i--) {
            //if (i == 2) {
                strings.remove(i);
            //}
        }
        System.out.println(strings.toString());

        Vector vector=new Vector();
        vector.add(1);
        HashMap<String,String> hashMap=new HashMap<>(2);
        hashMap.put("","");
        hashMap.put(null,null);
        hashMap.get("");
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        Hashtable hashtable=new Hashtable();

    }
}
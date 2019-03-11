package gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * 424509
 * @author zhangshipeng
 * 2018-12-28
 */
public class SoftReferenceHouse2 {
    public static void main(String[] args) {
        ArrayList<House> houses = new ArrayList<>();

        int i = 0;
        while (true) {
            houses.add(new House());
            System.out.println("i="+(++i));
        }
    }
}

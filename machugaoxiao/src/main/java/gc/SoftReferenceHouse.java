package gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 *424625
 * @author zhangshipeng
 * 2018-12-28
 */
public class SoftReferenceHouse {
    public static void main(String[] args) {
        ArrayList<SoftReference> houses = new ArrayList<>();

        int i = 0;
        while (true) {
            SoftReference<House> houseSoftReference = new SoftReference<House>(new House());
            houses.add(houseSoftReference);
            System.out.println("i="+(++i));
        }
    }
}

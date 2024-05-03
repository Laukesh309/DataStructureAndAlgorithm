package HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class hashSet {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(40);
        hs.add(10);
        System.out.println(hs);
        // contains
        System.out.println(hs.contains(10));
        // remove

        hs.remove(10);
        System.out.println(hs.contains(10));
        System.out.println(hs);
        System.out.println(hs.size());

        /// Iterator

        for (int key : hs) {
            System.out.println("key " + key);
        }

        // enhance for loop
        Iterator itr = hs.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());

        }
    }

}

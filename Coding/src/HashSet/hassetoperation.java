package HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class hassetoperation {

    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("gorakhpur");
        cities.add("noida");
        cities.add("delhi");
        cities.add("bangalore");
        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());

        // }

        for (String str : cities) {
            System.out.println(str);
        }
    }

}

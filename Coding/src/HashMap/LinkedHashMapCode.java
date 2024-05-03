package HashMap;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapCode {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lsm = new LinkedHashMap<>();
        lsm.put("first", 20);
        lsm.put("second", 20);
        lsm.put("third", 30);
        Set<String> keySet = lsm.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }
    }

}

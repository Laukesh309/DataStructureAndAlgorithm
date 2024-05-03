package HashMap;

import java.util.HashMap;
import java.util.Set;

public class ticket {

    public static String getStartPoint(HashMap<String, String> hs) {
        HashMap<String, String> revHashMap = new HashMap<>();
        for (String key : hs.keySet()) {
            revHashMap.put(hs.get(key), key);
        }
        for (String key : hs.keySet()) {
            if (!revHashMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("Chennai", "Bengaluru");
        hs.put("Mumbai", "Delhi");
        hs.put("Goa", "Chennai");
        hs.put("Delhi", "Goa");
        String starting = getStartPoint(hs);
        while (hs.containsKey(starting)) {
            System.out.print(starting + " -> ");
            starting = hs.get(starting);

        }
        System.out.print(starting);
    }

}

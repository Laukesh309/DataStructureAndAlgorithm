package HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findAllIternaryR1 {

    public static String findSource(HashMap<String, String> hm) {
        HashSet<String> keySet = new HashSet<>();
        HashSet<String> valueSet = new HashSet<>();
        for (String string : hm.keySet()) {
            keySet.add(string);
            valueSet.add(hm.get(string));
        }
        String result = "";
        for (String key : keySet) {
            if (!valueSet.contains(key)) {
                result = key;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("chennai", "bangaluru");
        hm.put("mumbai", "delhi");
        hm.put("goa", "chennai");
        hm.put("delhi", "goa");
        String src = findSource(hm);
        System.out.print(src + "=>");
        while (hm.containsKey(src)) {
            System.out.print(hm.get(src) + "=>");
            src = hm.get(src);
        }
    }

}

package HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class findItenary {

    public static String getStartingPosition(HashMap<String, String> destination) {
        Set<String> starting = destination.keySet();
        HashSet<String> ending = new HashSet<>();
        Iterator itr = starting.iterator();
        while (itr.hasNext()) {
            ending.add(destination.get(itr.next()));

        }
        for (String key : starting) {
            if (!ending.contains(key)) {
                return key;
            }
        }

        return "";
    }

    public static void pringIntery(HashMap<String, String> position, String inititalPosition) {
        while (inititalPosition != null) {
            System.out.print(inititalPosition + "->");
            inititalPosition = position.get(inititalPosition);
        }

    }

    public static void main(String[] args) {
        HashMap<String, String> destinations = new HashMap<>();
        destinations.put("chennai", "bangalore");
        destinations.put("mumbai", "delhi");
        destinations.put("goa", "chennai");
        destinations.put("delhi", "goa");
        String startingPosition = getStartingPosition(destinations);
        // System.out.println(startingPosition);
        pringIntery(destinations, startingPosition);
    }

}

package String;

import java.util.ArrayList;

public class closestString {

    public static int findDistance(ArrayList<String> str, String word1, String word2) {
        int firstIndex = -1;
        int secondIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < str.size(); i++) {
            String currString = str.get(i);
            if (currString.equals(word1)) {
                firstIndex = i;
            }
            if (currString.equals(word2)) {
                secondIndex = i;
            }
            if (firstIndex != -1 && secondIndex != -1) {
                minDistance = Math.min(minDistance, Math.abs(firstIndex - secondIndex));
            }
        }
        System.out.println(minDistance);
        return minDistance;

    }

    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        str.add("the");
        str.add("quick");
        str.add("brown");
        str.add("fox");
        str.add("quick");
        String word1 = "the";
        String word2 = "fox";
        System.out.println(findDistance(str, word1, word2));

    }

}

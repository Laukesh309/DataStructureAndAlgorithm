package GraphRevision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AllienDicnari {

    public static String findTopo(HashMap<Character, ArrayList<Character>> temp, HashMap<Character, Integer> inOrder) {
        Queue<Character> que = new LinkedList<>();
        for (Character character : inOrder.keySet()) {
            if (inOrder.get(character) == 0) {
                que.add(character);
            }

        }
        String result = "";
        while (!que.isEmpty()) {
            char currentChar = que.poll();
            result = result + currentChar;
            System.out.println(currentChar);
            if (temp.containsKey(currentChar)) {
                for (int i = 0; i < temp.get(currentChar).size(); i++) {
                    char dest = temp.get(currentChar).get(i);
                    inOrder.put(dest, inOrder.get(dest) - 1);
                    if (inOrder.get(dest) == 0) {
                        que.add(dest);
                    }
                }
            }

        }
        if (result.length() == inOrder.size()) {
            return result;
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        String words[] = { "dddc", "a", "ad", "ab", "b", "be", "cd", "cded" };
        HashMap<Character, ArrayList<Character>> temp = new HashMap<>();
        String prevString = words[0];
        for (int i = 1; i < words.length; i++) {
            String nextString = words[i];
            if (nextString.length() < prevString.length() && prevString.startsWith(nextString)) {
                return "";
            }
            for (int j = 0; j < Math.min(prevString.length(), nextString.length()); j++) {
                if (prevString.charAt(j) != nextString.charAt(j)) {
                    ArrayList<Character> tempResult = temp.getOrDefault(prevString.charAt(j), new ArrayList<>());
                    tempResult.add(nextString.charAt(j));
                    temp.put(prevString.charAt(j), tempResult);
                    break;
                }
            }
            prevString = nextString;
        }

        Set<Character> vertex = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String tempString = words[i];
            for (int j = 0; j < tempString.length(); j++) {
                vertex.add(tempString.charAt(j));
            }

        }

        HashMap<Character, Integer> inOrder = new HashMap<>();
        for (Character character : vertex) {
            inOrder.put(character, 0);
        }
        for (Character character : temp.keySet()) {
            for (int i = 0; i < temp.get(character).size(); i++) {
                char dest = temp.get(character).get(i);
                inOrder.put(dest, inOrder.getOrDefault(dest, 0) + 1);
            }
        }
        System.out.println(temp);
        System.out.println(findTopo(temp, inOrder));

    }

}

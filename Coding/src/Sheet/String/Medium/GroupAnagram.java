package Sheet.String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static List<List<String>> GroupAnagramSol(String[] str) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hs = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String currentWord = str[i];
            char sortedString[] = currentWord.toCharArray();
            Arrays.sort(sortedString);
            String newString = new String(sortedString);
            if (hs.containsKey(newString)) {
                ArrayList<String> temp = hs.get(newString);
                temp.add(currentWord);
                hs.put(newString, temp);

            } else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(currentWord);
                hs.put(newString, tempList);

            }
        }
        for (ArrayList<String> arrayList : hs.values()) {
            result.add(arrayList);
        }
        System.out.println(hs.values());
        return result;

    }

    public static void main(String[] args) {
        String[] str = { "a" };
        System.out.println(GroupAnagramSol(str));
    };

}

package Sheet.String.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class validAnagram {

    public static boolean checkAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char tempS[] = s.toCharArray();
        char tempT[] = t.toCharArray();
        Arrays.sort(tempS);
        Arrays.sort(tempT);
        String str1 = new String(tempS);
        String str2 = new String(tempT);
        return str1.equals(str2);

    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "tar";
        System.out.println(checkAnagram(s, t));
    }

}

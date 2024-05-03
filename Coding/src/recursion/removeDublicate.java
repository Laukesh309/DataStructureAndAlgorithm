package recursion;

public class removeDublicate {

    public static void removeDublicate(String str, int currentIndex, StringBuilder newString, boolean map[]) {
        if (currentIndex == str.length()) {
            System.out.println(newString);
            return;
        }
        char currentChar = str.charAt(currentIndex);
        if (map[currentChar - 'a'] == true) {
            removeDublicate(str, currentIndex + 1, newString, map);

        } else {
            map[currentChar - 'a'] = true;
            newString.append(currentChar);
            removeDublicate(str, currentIndex + 1, newString, map);
        }
        return;
    }

    public static void main(String[] args) {
        String str = "appnacollegeee";
        removeDublicate(str, 0, new StringBuilder(""), new boolean[26]);

    }

}

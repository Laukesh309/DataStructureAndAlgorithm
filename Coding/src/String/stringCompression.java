package String;

public class stringCompression {

    public static void findStringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char currentCharacter = str.charAt(0);
        sb.append(currentCharacter);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentCharacter) {
                counter++;
            } else {
                if (counter > 1) {
                    sb.append(counter);
                }
                currentCharacter = str.charAt(i);
                sb.append(currentCharacter);
                counter = 1;
            }
        }
        if (counter > 1) {
            sb.append(counter);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        // String str = "abc";
        findStringCompression(str);
    }

}

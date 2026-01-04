package SlidingWindowGFG.Easy;

public class removeConsecutiveCharacter {

    public static String removeConsecutiveCharacter(String s) {
        String result = s.charAt(0) + "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result = result + s.charAt(i);
            }
        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(removeConsecutiveCharacter(s));
    }

}

package TwoPointerGFG.Medium;

public class rotateStringinReverse {

    public static void printArray(int freq[]) {
        for (int i : freq) {
            System.out.print(i + " ");
        }
    }

    public static void findString(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            freq[currentChar - 'a'] = freq[currentChar - 'a'] + 1;
        }
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        int flag = 0;
        while (left <= right) {
            if (flag == 0) {
                char curChar = sb.charAt(left);
                if (freq[curChar - 'a'] == 1) {
                    left++;
                } else {
                    freq[curChar - 'a'] = freq[curChar - 'a'] - 1;
                    sb.setCharAt(left, '#');
                    left++;
                    flag = 1;
                }
            } else {
                char curChar = sb.charAt(right);
                if (freq[curChar - 'a'] == 1) {
                    right--;
                } else {
                    freq[curChar - 'a'] = freq[curChar - 'a'] - 1;
                    sb.setCharAt(right, '#');
                    flag = 0;
                    right--;
                }
            }
        }
        if (flag == 1) {
            sb.reverse();
        }
        String result = "";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                result = result + sb.charAt(i);
            }
        }
        return result;
        printArray(freq);
    }

    public static void main(String[] args) {
        String S = "dddd";
        findString(S);
    }

}

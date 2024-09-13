package TwoPointer;

// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class isSubSequence {

    public static boolean findIsSubSequence(String str1, String str2) {
        int firstLast = str1.length() - 1;
        int secondLast = str2.length() - 1;
        while (firstLast >= 0 && secondLast >= 0) {
            if (str2.charAt(secondLast) == str1.charAt(firstLast)) {
                secondLast--;
            }
            firstLast--;
        }
        if (secondLast < 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String str1 = "ahbgdc";
        String str2 = "abc";
        System.out.println(findIsSubSequence(str1, str2));
    }

}

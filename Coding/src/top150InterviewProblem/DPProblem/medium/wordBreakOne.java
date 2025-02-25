package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.List;

public class wordBreakOne {

    public static boolean findDic(String str, List<String> dictionary, int currentIndex) {
        System.out.println(str);
        if (str.isEmpty()) {
            return true;
        }
        if (currentIndex > str.length()) {
            return false;
        }
        if (dictionary.contains(str.substring(0, currentIndex))) {
            return findDic(str.substring(currentIndex), dictionary, 0) || findDic(str, dictionary, currentIndex + 1);
        }
        return findDic(str, dictionary, currentIndex + 1);
    }

    public static boolean findDicLast(String str, List<String> dict, int currentIndex) {
        if (str.isEmpty()) {
            return true;
        }
        if (currentIndex < 0) {
            return false;
        }
        if (dict.contains(str.substring(currentIndex))) {
            return findDicLast(str.substring(0, currentIndex), dict, currentIndex - 1)
                    || findDicLast(str, dict, currentIndex - 1);
        }
        return findDicLast(str, dict, currentIndex - 1);
    }

    public static boolean findDicTwoPointer(String str, List<String> dict, int start, int end, boolean dp[][]) {
        if (end == str.length()) {
            return dict.contains(str.subSequence(start, end));
        }
        if (dp[start][end]) {
            return true;
        }
        boolean temp = false;
        if (dict.contains(str.substring(start, end))) {
            temp = findDicTwoPointer(str, dict, end, end, dp);
        }
        dp[start][end] = temp || findDicTwoPointer(str, dict, start, end + 1, dp);
        return dp[start][end];
    }

    public static boolean findDicDynamic(String str, List<String> dict) {
        boolean dp[][] = new boolean[str.length()+1][str.length()+1];
        for(int i=str.length();i>=0;i--){
            for(int j=i;i<=str.length();j++){
                if(i==str.length() || j==str.length()){
                    dp[i][j]=true;
                }
            }
        }
        for(int i=str.length()-1;i>=0;i--){
            for(int column=i;column<str.length();column++){
                if(dict.contains(str.substring(i,column+1))){
                    dp[i][column]= 
                })
            }
        }

    }

    public static void main(String[] args) {
        String str = "aaaaaaa";

        List<String> dictionary = new ArrayList<String>();
        String result[] = { "aaaa", "aaa" };
        for (String s : result) {
            dictionary.add(s);

        }
        boolean dp[][] = new boolean[str.length()][str.length()];

        System.out.println(findDic(str, dictionary, 0));
        System.out.println(findDicLast(str, dictionary, str.length() - 1));
        System.out.println(findDicTwoPointer(str, dictionary, 0, 0, dp));

    }

}

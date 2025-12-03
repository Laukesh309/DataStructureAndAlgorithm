package top150InterviewProblem.Array;

public class zigzagconversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String[] ans = new String[numRows];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = "";
        }

        int currentStringIndex = 0;
        while (currentStringIndex < s.length()) {
            for (int index = 0; index < numRows; index++) {
                if (currentStringIndex < s.length()) {
                    ans[index] += s.charAt(currentStringIndex++);
                }
            }
            for (int index = numRows - 2; index > 0; index--) {
                if (currentStringIndex < s.length()) {
                    ans[index] += s.charAt(currentStringIndex++);
                }
            }

        }
        String res = "";
        for (String str : ans) {
            res += str;

        }
        System.out.println(res);

    }

}

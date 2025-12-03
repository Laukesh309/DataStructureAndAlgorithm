package top150InterviewProblem.String;

public class largentAddString {

    public static String LargentAddString(String str) {

        for (int i = str.length() - 1; i >= 0; i--) {
            String ch = "" + str.charAt(i);
            if (Integer.parseInt(ch) % 2 != 0) {
                return str.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "35427";
        System.out.println(LargentAddString(num));
    }

}

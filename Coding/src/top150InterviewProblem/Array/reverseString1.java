package top150InterviewProblem.Array;

public class reverseString1 {

    public static void printArray(String str[]) {
        for (String string1 : str) {
            System.out.println(string1 + "laukesh");

        }
    }

    public static void reverseString(String str) {
        String result[] = str.split(" ");
        String resultString = "";
        for (int i = result.length - 1; i >= 0; i--) {
            String currentString = result[i].trim();
            if (currentString != "") {
                resultString += " " + currentString;
            }

        }
        System.out.println(resultString.trim());

    }

    public static void main(String[] args) {
        String str = " a good        example";
        reverseString(str);
    }

}

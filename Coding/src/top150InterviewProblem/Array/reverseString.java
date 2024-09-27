package top150InterviewProblem.Array;

public class reverseString {

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static String reverseString(String str) {
        String newString = str.trim();
        String arr[] = newString.split(" ");
        int start = 0;
        int last = arr.length - 1;
        while (start <= last) {
            String temp = arr[start];
            arr[start++] = arr[last];
            arr[last--] = temp;

        }
        return String.join(" ", arr);

    }

    public static void main(String[] args) {
        String s = "    the sky is blue   ";
        System.out.println(reverseString(s));
    }

}

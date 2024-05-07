package Backtracking;

public class findSubSetR1 {

    public static void findAllSubSet(String str, int currentIndex, String result) {
        if (currentIndex >= str.length()) {
            System.out.println(result);
            return;
        }
        findAllSubSet(str, currentIndex + 1, result + str.charAt(currentIndex));
        findAllSubSet(str, currentIndex + 1, result);
    }

    public static void main(String[] args) {
        String str = "abc";
        findAllSubSet(str, 0, "");
    }

}

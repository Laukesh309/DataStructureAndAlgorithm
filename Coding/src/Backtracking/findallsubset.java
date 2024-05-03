package Backtracking;

public class findallsubset {

    public static void findAllSubsetImp(String str, String ans, int index) {
        if (index == str.length()) {
            System.out.println(ans);
            return;
        }
        findAllSubsetImp(str, ans, index + 1);
        findAllSubsetImp(str, ans + str.charAt(index), index + 1);

        return;

    }

    public static void main(String[] args) {
        String str = "abc";
        findAllSubsetImp(str, "", 0);

    }

}

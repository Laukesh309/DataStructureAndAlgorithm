package recursion;

public class FindAllSubString1 {

    public static void findAllString(String str, String ans, int index) {
        if (str.length() == index) {
            System.out.println(ans);
            return;
        }
        findAllString(str, ans + str.charAt(index), index + 1);
        findAllString(str, ans, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findAllString(str, "", 0);
    }

}

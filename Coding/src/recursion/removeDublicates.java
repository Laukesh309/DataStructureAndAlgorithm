package recursion;

public class removeDublicates {

    public static String removeDublicate(String str, String result) {
        if (str.isEmpty()) {
            return result;
        }
        if (!result.contains(str.charAt(0) + "")) {
            return removeDublicate(str.substring(1), result + str.charAt(0));
        }
        return removeDublicate(str.substring(1), result);
    }

    public static void main(String[] args) {
        String str = "appnnacollege";

        System.out.println(removeDublicate(str, ""));
    }

}

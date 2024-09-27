package recursion.recursionRevision;

public class removeDublicate {

    public static String removeDublicate(String str, int currentIndex, String result, boolean arr[]) {
        if (currentIndex == str.length()) {
            return result;
        }
        if (arr[str.charAt(currentIndex) - 'a']) {
            return removeDublicate(str, currentIndex + 1, result, arr);
        }
        arr[str.charAt(currentIndex) - 'a'] = true;
        return removeDublicate(str, currentIndex + 1, result + str.charAt(currentIndex), arr);

    }

    public static void main(String[] args) {
        String str = "appnacollege";
        boolean arr[] = new boolean[26];
        System.out.println(removeDublicate(str, 0, "", arr));
    }

}

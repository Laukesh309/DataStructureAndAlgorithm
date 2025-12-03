package BitManipulation;

public class addBinary {

    public static String findSum(String a, String b) {
        int carry = 0;
        int left = a.length() - 1;
        int right = b.length() - 1;
        String result = "";
        while (left >= 0 && right >= 0) {
            int sum = Integer.parseInt(a.charAt(left) + "") + Integer.parseInt(b.charAt(right) + "") + carry;
            carry = sum / 2;
            result = sum % 2 + result;
            left--;
            right--;
        }
        while (left >= 0) {
            int sum = Integer.parseInt(a.charAt(left) + "") + carry;
            carry = sum / 2;
            result = sum % 2 + result;
            left--;
        }
        System.out.println("se");
        while (right >= 0) {
            int sum = Integer.parseInt(b.charAt(right) + "") + carry;
            carry = sum / 2;
            result = sum % 2 + result;
            right--;
        }
        if (carry > 0) {
            result = carry + result;
        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        findSum(a, b);

    }

}

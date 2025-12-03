package Stack;

import java.util.Stack;

public class removeKDigit {

    public static String findMinNo(String num, int k) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        while (index < num.length()) {
            char curChar = num.charAt(index);
            int curNum = curChar - '0';
            while (k > 0 && !st.isEmpty() && st.peek() > curNum) {
                st.pop();
                k--;
            }
            index++;
            st.push(curNum);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        String sum = "";
        int stackLenght = st.size();
        for (int i = 0; i < stackLenght; i++) {
            int curNo = st.pop();
            sum = curNo + sum;
        }
        System.out.println(sum);
        String result = sum.replaceAll("^0+", "");
        System.out.println(result);
        return result.length() == 0 ? "0" : result;

    }

    public static void main(String[] args) {
        String num = "10001";
        int k = 1;
        System.out.println(findMinNo(num, k));

    }

}

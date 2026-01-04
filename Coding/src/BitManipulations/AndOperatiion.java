package BitManipulations;

public class AndOperatiion {

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        int count = 0;
        while (left != right) {
            right = right >> 1;
            left = left >> 1;
            count++;
        }
        while (count > 0) {
            left = left << 1;
            count--;
        }
        System.out.println(left);
    }

}

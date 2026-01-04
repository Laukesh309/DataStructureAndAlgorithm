package BitManipulations;

public class singleSecond {

    public static void main(String[] args) {
        int nums[] = { 2, 2, 3, 2 };
        int once = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            once = (once ^ nums[i]) & ~two;
            two = (two ^ nums[i]) & ~once;
        }
        System.out.println(once);
    }

}

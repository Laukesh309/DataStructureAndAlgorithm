package DynamicProgramming;

public class CatalonNumberR1 {

    public static int findCatalonNumber(int number) {
        int cp[] = new int[number + 1];
        cp[0] = 1;
        cp[1] = 1;
        for (int i = 2; i <= number; i++) {
            int result = 0;
            for (int j = 0, k = i - 1; j < i; j++, k--) {
                result += cp[j] * cp[k];
            }
            cp[i] = result;
        }
        return cp[number];
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(findCatalonNumber(num));
    }

}

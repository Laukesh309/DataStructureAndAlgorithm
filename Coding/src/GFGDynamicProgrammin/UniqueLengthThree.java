package GFGDynamicProgrammin;

public class UniqueLengthThree {

    public static void printData(int prefix[][]) {
        for (int[] is : prefix) {
            for (int is2 : is) {
                System.out.print(is2 + " ");

            }
            System.out.println();
        }
    }

    public static void findTotalSubSequenceDynamic(String str) {

        int prefix[][] = new int[10][10];
        int suffix[][] = new int[10][10];
        int right[] = new int[10];
        int left[] = new int[10];
        for (int i = str.length() - 1; i >= 0; i--) {
            int currentIndex = str.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                suffix[currentIndex][j] += right[j];
            }
            right[currentIndex]++;
        }
        long total = 0;
        for (int i = 0; i < str.length(); i++) {

            int currentIndex = str.charAt(i) - '0';
            right[currentIndex]--;
            for (int j = 0; j < 10; j++) {
                suffix[currentIndex][j] -= right[j];
            }
            for (int row = 0; row < 10; row++) {
                for (int j = 0; j < 10; j++) {
                    total = total + prefix[row][j] * suffix[j][row];
                }
            }
            for (int j = 0; j < 10; j++) {
                prefix[j][currentIndex] += left[j];
            }
            left[currentIndex]++;
        }
        System.out.println(total);

    }

    public static void main(String[] args) {
        String s = "103301";
        // findTotalSequence(s);
        findTotalSubSequenceDynamic(s);

    }

}

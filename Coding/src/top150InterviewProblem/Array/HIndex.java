package top150InterviewProblem.Array;

public class HIndex {

    public static void printArray(int result[]) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        int citations[] = { 3, 0, 6, 1, 5 };
        int result[] = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            int currentCitaions = citations[i];
            if (currentCitaions >= result.length - 1) {
                result[result.length - 1] = result[result.length - 1] + 1;
            } else {
                result[currentCitaions] = result[currentCitaions] + 1;
            }
        }
        int count = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            count = result[i] + count;
            if (count >= i) {

                return i;
            }
        }

    }

}

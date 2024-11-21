package recursion;

public class permutationSebSequence {

    public static String getValue(int result[], int currentIndex, int k[], String currentResult) {
        if (currentIndex >= result.length) {
            k[0]--;
            System.out.println(currentResult);
            if (k[0] == 0) {

                return currentResult;
            }
            // return currentResult;
            return "";
        }
        String currResult = "";
        for (int i = currentIndex; i < result.length; i++) {
            int temp = result[i];
            result[i] = result[currentIndex];
            result[currentIndex] = temp;
            currResult = getValue(result, currentIndex + 1, k, currentResult + result[currentIndex]);
            if (!currResult.isEmpty()) {
                return currResult;
            } else {
                result[currentIndex] = result[i];
                result[i] = temp;
            }

        }
        return currResult;

    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        int finalResult[] = { k };
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        System.out.println(getValue(result, 0, finalResult, ""));
    }

}

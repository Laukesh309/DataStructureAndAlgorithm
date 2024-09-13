package array;

public class maxProductSum {

    public static int maxProduct(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        int product = 1;

        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            maxValue = Math.max(maxValue, product);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            product *= arr[i];
            maxValue = Math.max(maxValue, product);
            if (product == 0) {
                product = 1;
            }

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 0, -1 };
        System.out.println(maxProduct(arr));

    }

}

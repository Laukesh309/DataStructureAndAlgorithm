package Sheet.Array.medium;

//https://leetcode.com/problems/product-of-array-except-self/submissions/1370069781/
public class productofarrayexceptitself {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    /// best solution without any auxilary space
    public static int[] getProductAuxilarySpace(int arr[]) {
        int ans[] = new int[arr.length];
        int prifix = 1;
        /// calculate prifix
        for (int i = 0; i < arr.length; i++) {
            ans[i] = prifix;
            prifix = arr[i] * prifix;
        }
        // calculate suffix
        int suffix = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            ans[j] = ans[j] * suffix;
            suffix = arr[j] * suffix;
        }
        return ans;
    }

    public static int[] getProductResult(int arr[]) {
        int prifix[] = new int[arr.length];
        int suffix[] = new int[arr.length];
        int prefixResult = 1;
        for (int i = 0; i < arr.length; i++) {
            prifix[i] = prefixResult;
            prefixResult = prefixResult * arr[i];
        }
        int suffixResult = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            suffix[j] = suffixResult;
            suffixResult = arr[j] * suffixResult;
        }
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = prifix[i] * suffix[i];
        }
        return result;
    }

    //// leet code solution
    // public int[] productExceptSelf(int[] arr) {
    // int prefix[] = new int[arr.length];
    // int suffix[] = new int[arr.length];
    // prefix[0] = arr[0];
    // for (int i = 1; i < arr.length; i++) {
    // prefix[i] = arr[i] * prefix[i - 1];
    // }
    // suffix[arr.length - 1] = arr[arr.length - 1];
    // for (int j = arr.length - 2; j >= 0; j--) {
    // suffix[j] = arr[j] * suffix[j + 1];
    // }
    // for (int i = 0; i < arr.length; i++) {
    // if (i - 1 < 0) {
    // arr[i] = suffix[i + 1];
    // } else if (i + 1 >= arr.length) {
    // arr[i] = prefix[i - 1];
    // } else {
    // arr[i] = prefix[i - 1] * suffix[i + 1];
    // }
    // }
    // return arr;

    // }

    public static void main(String[] args) {
        int arr[] = { -1, 1, 0, -3, 3 };
        // int result[] = getProductResult(arr);
        int result[] = getProductAuxilarySpace(arr);
        printArray(result);

    }

}

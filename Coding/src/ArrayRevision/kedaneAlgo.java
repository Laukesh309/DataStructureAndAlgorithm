package ArrayRevision;

public class kedaneAlgo {

    public static int findMaxSubArray(int arr[]) {
        int gMax = arr[0];
        int curmax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curmax = Math.max(curmax + arr[i], arr[i]);
            gMax = Math.max(curmax, gMax);
        }
        return gMax;
    }

    public static void main(String[] args) {
        int arr[] = { -2, -4 };
        System.out.println(findMaxSubArray(arr));
    }

}

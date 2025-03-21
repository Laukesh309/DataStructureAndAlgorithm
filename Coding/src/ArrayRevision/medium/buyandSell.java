package ArrayRevision.medium;

public class buyandSell {

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            result = Math.max(result, arr[i] - minPrice);
        }
        System.out.println(result);
    }

}

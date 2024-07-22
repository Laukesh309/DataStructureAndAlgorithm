package array.GeekForGeek;

//https://www.geeksforgeeks.org/problems/max-min/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class findMinAndMax {

    public static int findSumOfMinAndMax(int arr[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max + min;
    }

    public static void main(String[] args) {
        // int arr[] = { -2, 1, -4, 5, 3 };
        int arr[] = { 1, 3, 4, 1 };
        System.out.println(findSumOfMinAndMax(arr));
    }

}

package array;

public class removeDublicateSorted {

    public static int removeDublicate(int arr[]) {
        int first = -1;
        int second = 0;
        int prev = -200;
        int counter = 0;
        int result = 0;
        while (second < arr.length) {
            int currentValue = arr[second];
            if (prev != currentValue) {
                first++;
                int temp = arr[first];
                arr[first] = arr[second];
                arr[second] = temp;
                prev = arr[first];
                counter++;
            }
            second++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1 };
        System.out.println(removeDublicate(arr));
    }

}

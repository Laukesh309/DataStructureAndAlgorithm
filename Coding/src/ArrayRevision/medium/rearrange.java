package ArrayRevision.medium;

public class rearrange {

    public static void main(String[] args) {
        int arr[] = { -1, 1 };
        int add[] = new int[arr.length / 2];
        int even[] = new int[arr.length / 2];
        int evenCount = 0;
        int addCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                even[evenCount++] = arr[i];
            } else {
                add[addCount++] = arr[i];
            }
        }
        int result[] = new int[arr.length];
        evenCount = 0;
        addCount = 0;
        int currentIndex = 0;
        while (evenCount < even.length && addCount < add.length) {
            result[currentIndex++] = even[evenCount++];
            result[currentIndex++] = add[addCount++];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}

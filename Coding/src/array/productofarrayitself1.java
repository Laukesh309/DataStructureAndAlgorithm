package array;

public class productofarrayitself1 {

    public static int findNumberOfZero(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void findValue(int arr[]) {
        int noOfZero = findNumberOfZero(arr);
        int maxValue = 1;
        if (noOfZero == 0) {
            for (int i = 0; i < arr.length; i++) {
                maxValue = maxValue * arr[i];
            }
        } else if (noOfZero == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    maxValue = maxValue * arr[i];
                }
            }
        } else {
            maxValue = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (noOfZero == 0) {
                arr[i] = maxValue / arr[i];
            } else if (noOfZero == 1) {
                if (arr[i] == 0) {
                    arr[i] = maxValue;
                } else {
                    arr[i] = 0;
                }
            } else {
                arr[i] = 0;
            }

        }
    }

    public static void findByPrifixAndSuffix(int arr[]) {
        int prefix[] = new int[arr.length];
        int suffix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] * prefix[i - 1];
        }
        suffix[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length - 2; j >= 0; j--) {
            suffix[j] = arr[j] * suffix[j + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i - 1 < 0) {
                arr[i] = suffix[i + 1];
            } else if (i + 1 >= arr.length) {
                arr[i] = prefix[i - 1];
            } else {
                arr[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4 };
        // int arr[] = { 0, 0 };
        int arr[] = { -1, 1, 0, -3, 3 };
        // findValue(arr);
        findByPrifixAndSuffix(arr);
        printArray(arr);
    }

}

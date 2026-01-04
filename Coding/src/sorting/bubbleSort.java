package sorting;

public class bubbleSort {

    public static void bubbleSort(int nums[]) {
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
        // printArray(nums);

    }

    public static void selectionSort(int nums[]) {

        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        printArray(nums);
    }

    public static void insertionSor(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
                j--;
            }
            nums[j + 1] = temp;
        }
        printArray(nums);
    }

    public static void sort(int nums[], int startIndex, int mid, int endIndex) {
        int totalLenght = endIndex - startIndex + 1;
        int tempArray[] = new int[totalLenght];
        int firstStartIndex = startIndex;
        int secondPointer = mid + 1;
        int index = 0;
        while (startIndex <= mid && secondPointer <= endIndex) {
            if (nums[startIndex] <= nums[secondPointer]) {
                tempArray[index] = nums[startIndex++];
            } else {
                tempArray[index] = nums[secondPointer++];
            }
            index++;
        }
        while (startIndex <= mid) {
            tempArray[index++] = nums[startIndex++];

        }
        while (secondPointer <= endIndex) {
            tempArray[index++] = nums[secondPointer++];
        }
        int currentCounter = 0;
        for (int i = firstStartIndex; i <= endIndex; i++) {
            nums[i] = tempArray[currentCounter++];
        }
        return;
    }

    public static void mergeSort(int num[], int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;
        mergeSort(num, startIndex, mid);
        mergeSort(num, mid + 1, endIndex);
        sort(num, startIndex, mid, endIndex);

    }

    public static void printArray(int nums[]) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 5, 4, 1, 3, 2 };
        // bubbleSort(nums);
        // selectionSort(nums);
        // insertionSor(nums);
        mergeSort(nums, 0, nums.length - 1);
        printArray(nums);
    }

}

package BinarySearch;

public class findCeilString {

    public static char findCeil(char arr[], char target, int start, int end, char result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] > target) {
            return findCeil(arr, target, start, mid - 1, arr[mid]);
        } else {
            return findCeil(arr, target, mid + 1, end, result);
        }

    }

    public static void main(String[] args) {
        char arr[] = { 'a', 'c', 'f', 'h' };
        char target = 'a';
        char result = findCeil(arr, target, 0, arr.length - 1, '0');
        System.out.println(result);

    }

}

package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class iterativeSubSet1 {

    public static void findSubSet(int arr[], int currentIndex, ArrayList<ArrayList<Integer>> finalArray,
            ArrayList<Integer> tempArray) {
        finalArray.add(new ArrayList<>(tempArray));
        for (int i = currentIndex; i < arr.length; i++) {
            int currentValue = arr[i];
            tempArray.add(currentValue);
            findSubSet(arr, i + 1, finalArray, tempArray);
            tempArray.remove(tempArray.size() - 1);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        ArrayList<Integer> tempArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finalArray = new ArrayList<>();
        findSubSet(arr, 0, finalArray, tempArray);
        System.out.println(finalArray);
    }

}

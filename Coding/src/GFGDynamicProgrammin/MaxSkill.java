package GFGDynamicProgrammin;

public class MaxSkill {

    public static int findMaxValue(int arr[], int currentIndex, int preInvex, int nextIndex) {

        if (currentIndex >= arr.length) {
            return 0;
        }
        int prevValue = 1;
        int nextValue = 1;
        if (preInvex != -1) {
            prevValue = arr[preInvex];
        }
        if (nextIndex != arr.length) {
            nextValue = arr[nextIndex];
        }
        int include = arr[currentIndex] * prevValue * nextValue
                + findMaxValue(arr, nextIndex, preInvex, nextIndex + 1);
        int exlude = findMaxValue(arr, nextIndex, currentIndex, nextIndex + 1);
        return Math.max(include, exlude);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 5, 8 };
        int prevIndex = -1;
        int currentindex = 0;
        int nextIndex = 1;
        System.out.println(findMaxValue(arr, currentindex, prevIndex, nextIndex));
    }

}

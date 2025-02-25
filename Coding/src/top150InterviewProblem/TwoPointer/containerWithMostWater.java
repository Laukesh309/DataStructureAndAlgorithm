package top150InterviewProblem.TwoPointer;

public class containerWithMostWater {

    public static int findMaxWater(int height[]) {
        int start = 0;
        int end = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (start < end) {
            int currentMin = Math.min(height[start], height[end]);
            int breath = end - start;
            area = Math.max(area, currentMin * breath);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int height[] = { 1, 1 };
        System.out.println(findMaxWater(height));
    }

}

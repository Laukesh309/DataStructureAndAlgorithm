package StackRevision;

public class TappingRainWater {

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 3, 2, 5 };
        int prevMax = 0;
        int nextMax = 0;
        int prevResult[] = new int[height.length];
        int nextResult[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int lastIndex = height.length - i - 1;
            prevResult[i] = prevMax;
            if (height[i] > prevMax) {
                prevMax = height[i];
            }
            nextResult[lastIndex] = nextMax;
            if (height[lastIndex] > nextMax) {
                nextMax = height[lastIndex];
            }
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int minheight = Math.min(prevResult[i], nextResult[i]);
            int curHeight = minheight - height[i];
            if (curHeight > 0) {
                result = result + curHeight;
            }
        }
        System.out.println(result);
    }

}

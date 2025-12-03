package top150InterviewProblem;

import java.util.ArrayList;
import java.util.List;

public class summaryRange {

    public static void main(String[] args) {
        int nums[] = { 0, 2, 3, 4, 6, 8, 9 };
        List<String> result = new ArrayList<>();
        int curIndex = 0;
        while (curIndex < nums.length) {
            int tempIndex = curIndex;
            while (tempIndex + 1 < nums.length && nums[tempIndex] + 1 == nums[tempIndex + 1]) {
                tempIndex++;
            }
            if (tempIndex == curIndex) {
                result.add(nums[tempIndex] + "");
            } else {
                result.add(nums[curIndex] + "->" + nums[tempIndex]);
            }
            tempIndex++;
            curIndex = tempIndex;
        }
        System.out.println(result);
    }

}

package top150InterviewProblem.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMajorityElementMore {

    public static void main(String[] args) {
        int nums[] = { 3, 2, 3 };
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int totalCount = size / 3;
        int currentValue = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentValue == nums[i]) {
                count++;
            } else {
                if (count > totalCount) {
                    ans.add(currentValue);
                }
                currentValue = nums[i];
                count = 1;

            }

        }
        if (count > totalCount) {
            ans.add(currentValue);
        }
        System.out.println(ans);
    }

}

package cn.neyzoter.leetcode.algo.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args){
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(new Solution1_ThreeSumClosest().threeSumClosest(nums,target));
    }
}

class Solution1_ThreeSumClosest{
    public int threeSumClosest(int[] nums, int target) {
        int sum=0;
        if(nums.length <= 3){
            for (int num:nums) {
                sum+=num;
            }
            return sum;
        }
        Arrays.sort(nums);

        sum = nums[0] + nums[1] + nums[2];
        int i,left,right;
        int thisSum = 0;
        for (i = 0;i < (nums.length - 2);i++){   // 注意要从0开始，因为后面还有
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                thisSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - thisSum) < Math.abs(target - sum)){
                    sum = thisSum;
                    if (sum == target){
                        return sum;
                    }
                }
                if(thisSum > target){
                    right -= 1;
                }else{
                    left += 1;
                }
            }
        }
        return sum;

    }
}

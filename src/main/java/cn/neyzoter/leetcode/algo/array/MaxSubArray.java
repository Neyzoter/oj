package cn.neyzoter.leetcode.algo.array;

/**
 * 53 最大子序和
 */
public class MaxSubArray {
    public static void main(String[] args){
        int[] val = {-2,1,-3,4,-1,2,1,-5,4};
        Solution1_MaxSubArray solution1_maxSubArray = new Solution1_MaxSubArray();
        System.out.println(solution1_maxSubArray.maxSubArray(val));

    }
}

/**
 * 暴力法
 */
class Solution1_MaxSubArray{
    public int maxSubArray(int[] nums) {
        int maxVal = nums[0];
        int thisVal = nums[0];
        int i = 1;int num;
        for (;i < nums.length;i++){
            num = nums[i];
            if (thisVal + num >= num){
                thisVal += num;
            }else{
                thisVal = num;
            }
            if (maxVal <= thisVal){
                maxVal = thisVal;
            }
        }
        return maxVal;
    }
}

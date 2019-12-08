package cn.neyzoter.oj.hash;

/**
 * 136.只出现一次的数字
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        Solution1_SingleNumber solution1_singleNumber = new Solution1_SingleNumber();
        System.out.println(solution1_singleNumber.singleNumber(nums));
    }
}

/**
 * 暴力法
 */
class Solution1_SingleNumber {
    public int singleNumber(int[] nums) {
        boolean found = false;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0 ; j < nums.length; j ++) {
                // 跳出内层for
                if (i != j && nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return nums[i];
            }else {
                found = false;
            }
        }
        return 0;
    }
}

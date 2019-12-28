package cn.neyzoter.oj.array;

/**
 * 31.下一个排列（Next Permutation）
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[][] numses = {{1,2,3},{3,2,1},{1,1,5}};
//        int[][] numses = {{3,2,1}};
        Solution1_NextPermutation solution1_nextPermutation = new Solution1_NextPermutation();
        for (int[] nums : numses) {
            System.out.println();
            for (int num : nums) {
                System.out.print(num);System.out.print(" ");
            }
            solution1_nextPermutation.nextPermutation(nums);
            System.out.println();System.out.print("\t");
            for (int num : nums) {
                System.out.print(num);System.out.print(" ");
            }
        }
    }
}

/**
 *
 */
class Solution1_NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 2 ; i >=0 ; i --) {
            int tmp = nums[i];
            if (nums[i] < nums[len-1]) {
                for (int j = i + 1 ; j < len ; j ++) {
                    if (nums[i] < nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        return;
                    }
                }
            }else {
                for (int j = i + 1 ; j < len; j ++) {
                    nums[j - 1] = nums[j];
                }
                nums[len - 1] = tmp;
            }
        }
    }
}
package cn.neyzoter.exam.tencent.intv;

public class Test1 {
    public static final int NOT_FIND = -1;
    public static void main(String[] args) {
        test();
    }

    /**
     * 测试函数
     */
    public static void test() {
        int[] nums = {1, 3, 5, 6, 7};
//        int[] nums = null;
        int[] target = {1, 5, 10, -1};
        for (int t : target) {
            System.out.println("target : " + t + " index : " + binSearch(null, t));
        }
    }

    /**
     * 二分查找
     * @param nums 有序数组
     * @param target 目标
     * @return 下标，-1表示未找到
     */
    public static int binSearch(int[] nums, int target) {
        if (nums == null) {
            return NOT_FIND;
        }
        for (int left = 0, right = nums.length - 1; left <= right;) {
            int mid = left - (left - right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return NOT_FIND;
    }
}

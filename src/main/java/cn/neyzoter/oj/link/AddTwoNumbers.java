package cn.neyzoter.oj.link;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int[] nums = new int[] {1,2,3};
		int target = 4;
		Solution3 Sol = new Solution3();
		int[] idx_two = Sol.twoSum(nums,target);
		System.out.println(Arrays.toString(idx_two));
		time = System.currentTimeMillis() - time;
		System.out.println("Run Time:"+time+"ms");
	}
}

/**
 * 暴力法
 * @author songchaochao
 *
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target){
        int[] temp = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return temp;  
    }
}

/**
 * 两遍哈希表法
 * @author songchaochao
 *
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target){
    	Map<Integer,Integer> hashmap = new HashMap();
    	for(int idx=0;idx<nums.length;idx++) {
    		hashmap.put(nums[idx], idx);
    	}
    	for(int idx=0;idx<nums.length;idx++) {
    		if(hashmap.containsKey(target-nums[idx])&&hashmap.get(target-nums[idx])!=idx) {
    			return new int[] {idx,hashmap.get(target-nums[idx])};
    		}
    	}
    	return new int[] {};
    }
}

/**
 * 一遍哈希表法
 * @author songchaochao
 *
 */
class Solution3 {
    public int[] twoSum(int[] nums, int target){
    	Map<Integer,Integer> hashmap = new HashMap();
    	for(int idx=0;idx<nums.length;idx++) {
    		if(hashmap.containsKey(target-nums[idx])) {
    			return new int[] {hashmap.get(target-nums[idx]),idx};
    		}
    		hashmap.put(nums[idx], idx);
    	}
    	return new int[] {};
    }
}
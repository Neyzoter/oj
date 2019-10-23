package cn.neyzoter.oj.array;

import java.util.*;


public class ThreeSum{
	public static void main(String args[]){
		long time = System.currentTimeMillis();
		Solution sol = new Solution();
		int[] nums = {-1,1,0,1,1,0,2,-1-4, 0, 1, 2, -1, -4};
		System.out.print(sol.threeSum(nums).toString()+"\n");
		time = System.currentTimeMillis() - time;
		System.out.println("Run Time:"+time+"ms");
	}
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> rtn = new ArrayList<List<Integer>>();
    	if(nums.length<3) {
    		return rtn;
    	}
    	int target;
		Arrays.sort(nums);    	
		for(int idx_min=0;idx_min<nums.length-2;idx_min++) {
			if(idx_min>0&&nums[idx_min-1]==nums[idx_min]) {
				continue;
			}
			if(nums[idx_min]>0) {
				return rtn;
			}
			target = -nums[idx_min];
			//开始双指针
			int idx_mid=idx_min+1,idx_max=nums.length-1;
			while(idx_mid<idx_max) {
				if(nums[idx_mid]+nums[idx_max]==target) {
					rtn.add(Arrays.asList(nums[idx_min],nums[idx_mid],nums[idx_max]));
					idx_mid++;idx_max--;
					while(idx_mid<idx_max&&nums[idx_mid]==nums[idx_mid-1]) {
						idx_mid++;
					}
					while(idx_mid<idx_max&&nums[idx_max]==nums[idx_max+1]) {
						idx_max--;
					}
				}
				else if(nums[idx_mid]+nums[idx_max]>target) { //max需要变小
					idx_max--;
				}
				else {  //mid需要变大
					idx_mid++;
				}
			}
		}
		return rtn;
    }
}

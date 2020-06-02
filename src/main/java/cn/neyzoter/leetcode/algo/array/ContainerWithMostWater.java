package cn.neyzoter.leetcode.algo.array;

public class ContainerWithMostWater {
	public static void main(String args[]) {
		long time = System.currentTimeMillis();
		int[] height = {1,8,6,2,5,4,8,3,7};
		Solution_MaxArea2 sol = new Solution_MaxArea2();
		System.out.println("Max area is "+sol.maxArea(height));
		time = System.currentTimeMillis() - time;
		System.out.println("Run Time:"+time+"ms");
	}
}
/**
 * 暴力法
 * @author songchaochao
 *
 */
class Solution_MaxArea1 {
    public int maxArea(int[] height) {//假设height元素个数大于等于2
    	int area=0,lower,area_temp;
        for(int idx1=0;idx1<height.length-1;idx1++) {
        	for(int idx2 = idx1+1;idx2<height.length;idx2++) {
        		lower = height[idx1]>height[idx2]?height[idx2]:height[idx1];//选一个低的
        		area_temp = lower*(idx2-idx1);
        		area = area_temp>area?area_temp:area;
        	}
        }
        return area;
    }
}

/**
 * 双指针法
 * @author songchaochao
 *
 */
class Solution_MaxArea2 {
    public int maxArea(int[] height) {//假设height元素个数大于等于2
    	int area=0;
        for(int idx1=0,idx2=height.length-1;idx1<idx2;) {
        	area = Math.max(area, (idx2-idx1)*Math.min(height[idx2], height[idx1]));
        	if(height[idx2]>height[idx1]) {
        		idx1++;
        	}
        	else {
        		idx2--;
        	}
        }
        return area;
    }
}
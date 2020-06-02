package cn.neyzoter.leetcode.algo.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Solution_LengthOfLongestSubstring2 sol = new Solution_LengthOfLongestSubstring2();
		int length = sol.lengthOfLongestSubstring("pwwkew");
		System.out.println("Max Length: "+length);
		time = System.currentTimeMillis() - time ;
		System.out.println("Run Time : "+time+" ms");
	}
}
/**
 * 暴力法
 * @author songchaochao
 *
 */
class Solution_LengthOfLongestSubstring1 {
    public int lengthOfLongestSubstring(String s) {
    	int start=0,end=0;
    	int idx_find=0;
    	int length_max=0;
    	
    	while(end<s.length()) {
    		idx_find = start;
    		while(idx_find<end) {
    			if(s.charAt(idx_find)==s.charAt(end)) {//如果找到了一个相等的则可以确定start位置为下一个
    				start = idx_find+1;
    				break;
    			}
    			idx_find++;
    		}
    		length_max = (length_max<end-start+1)?(end-start+1):length_max;
    		end++;
    	}
    	return length_max;
    }
}

/**
 * 哈希表法
 * @author songchaochao
 *
 */
class Solution_LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
    	int sLength = s.length();
    	int length=0;
    	Map<Character, Integer> hashmap = new HashMap();
    	for(int start=0,end=0;end<sLength;end++) {
    		if(hashmap.containsKey(s.charAt(end))) {
    			start = hashmap.get(s.charAt(end))+1;
    		}
    		hashmap.put(s.charAt(end), end);//这里将相同char的坐标替换掉，变大
    		length = Math.max(length, end-start+1);
    	}
    	return length;
    }
}

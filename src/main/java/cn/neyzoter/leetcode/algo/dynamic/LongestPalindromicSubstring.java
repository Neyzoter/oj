package cn.neyzoter.leetcode.algo.dynamic;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abcba";
		Solution_LongestPalindrome2 sol = new Solution_LongestPalindrome2();
		System.out.println(sol.longestPalindrome(s));
	}
}
/**
 * 中心扩散法
 * @author songchaochao
 *
 */
class Solution_LongestPalindrome1 {
    public String longestPalindrome(String s) {
    	int length=0,start=0,end=0;
    	int len1,len2,len_temp;
        for(int mid=0;mid<s.length();mid++) {
        	len1 = getLen(s,mid,mid);
        	len2 = getLen(s,mid,mid+1);
        	len_temp = Math.max(len1, len2);
            if(length<len_temp){
            	length = len_temp;
            	start = mid - (len_temp - 1) / 2;
            	end = mid + len_temp / 2;
            }    
        }
        if(length!=0)
        	return s.substring(start, end+1);
        else
        	return "";
    }
    public int getLen(String s,int left,int right) {
    	int i=left,j=right;
        for(;i>=0&&j<s.length();i--,j++) {
        	if(s.charAt(i)!=s.charAt(j)) {
        		break;//不对称
        	}
        }
        return j-i-1;
    }
}
/**
 * 动态规划法
 * @author songchaochao
 *
 */
class Solution_LongestPalindrome2 {
	public String longestPalindrome(String s) {
		int length=0;
		if(s.length()<=0){
			return "";
		}
		else if(s.length()==1) {
			return s;
		}
		boolean[][] matrix = new boolean[s.length()][s.length()];
		
//++++++++++++++++++++++动态规划开始+++++++++++++++++++++++++//
		//长度为1和2的回文子串
		matrix[0][0]=true;
		length = 1;
		for(int idx=1;idx<s.length();idx++) {
			matrix[idx][idx] = true;
			matrix[idx-1][idx] = (s.charAt(idx)==s.charAt(idx-1))?true:false;
			if(matrix[idx-1][idx]) {
				length = 2;
			}
		}
		//长度3及以上的回文子串
		//三角形，只需要更新右上角
		for(int len=2;len<=s.length()-1;len++) {
			for(int idx=0;idx+len<s.length();idx++) {
				matrix[idx][idx+len] = ((s.charAt(idx)==s.charAt(idx+len))&&
						matrix[idx+1][idx+len-1]) ? true:false;
				length = (matrix[idx][idx+len])?(len+1):length;
			}
		}
		//遍历这个matrix
		for(int idx_y=s.length()-1;idx_y>0;idx_y--) {
			int idx_x = idx_y - length+1;
			if(idx_x>=0 && matrix[idx_x][idx_y]) {
				return s.substring(idx_x,idx_y+1);
			}
		}
//++++++++++++++++++++++动态规划结束++++++++++++++++++++++++++++++=//
		
		return "";
	}
}




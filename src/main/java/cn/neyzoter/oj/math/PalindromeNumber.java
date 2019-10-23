package cn.neyzoter.oj.math;

public class PalindromeNumber {
	public static void main(String args[]) {
		int x = 1;
		Solution_Palindrome sol = new Solution_Palindrome();
		if(sol.isPalindrome(x)) {
			System.out.println(x+" is palindrome!");
		}
		else {
			System.out.println(x+" is not palindrome!");
		}
	}
}
class Solution_Palindrome {
    public boolean isPalindrome(int x) {
    	int x_temp = x;
        if(x_temp<0) {
        	return false;
        }
        int temp=0;
        while(x_temp!=0) {
        	temp = temp * 10 + x_temp%10;
        	x_temp = x_temp / 10;
        }
        if(temp!=x) {
        	return false;
        }
        return true;
    }
}
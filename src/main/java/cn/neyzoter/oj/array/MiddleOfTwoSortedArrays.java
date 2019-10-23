package cn.neyzoter.oj.array;

public class MiddleOfTwoSortedArrays{
    public static double[] arr1 = {4};
    public static double[] arr2 = {1,2,6,7,8,9};
	public static void main(String[] args){
        System.out.println(Solution1.getMidVal(arr1,arr2));
	}
}

class Solution1{
    public static double getMidVal(double[] arr1,double[] arr2){
        int m = arr1.length;int n = arr2.length;
        int midLen = (m + n +1)/2;int remainder = (m + n + 1)%2;
        int i = (arr1[0]-arr1[m-1] > 0)?m-1:0;
        int j = (arr2[0]-arr2[n-1] > 0)?n-1:0;
        int change = 0;
        int inc1 = (arr1[0]-arr1[m-1] > 0)?-1:1;
        int inc2 = (arr2[0]-arr2[n-1] > 0)?-1:1;

        for(;i+j < (midLen + remainder);){
            if(arr1[i]>arr2[j]){
                j+=inc2;change = 1;
                System.out.println("j = "+j);
            }else {
                i+=inc1;change = 0;
                System.out.println("i = "+i);
            }
        }
        int idx = i - inc1;int jdx = j - inc2;
        System.out.println(String.format("idx of arr1 = %d , jdx of arr2 = %d\r\n",idx,jdx));
        return (remainder == 1)?((arr1[idx] + arr2[jdx])/2.0):((change == 1)?(arr2[jdx]):(arr1[idx]));
    }
}
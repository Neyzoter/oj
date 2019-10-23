package cn.neyzoter.oj.array;

public class MiddleOfTwoSortedArrays{
    public static double[] arr1 = {1,2,4};
    public static double[] arr2 = {1,6};
	public static void main(String[] args){
        System.out.println(Solution1.getMidVal(arr1,arr2));
	}
}

class Solution1{
    public static double getMidVal(double[] arr1,double[] arr2){
        int m = arr1.length;int n = arr2.length;
        int midLen = (m + n +1)/2;int remainder = (m + n + 1)%2;
        int i = 0,j = 0,change = 0;
        for(;i+j < (midLen + remainder);){
            if(arr1[i]>arr2[j]){
                j++;change = 1;
            }else {
                i++;change = 0;
            }
        }
        return (remainder == 1)?((arr1[i] + arr1[j])/2.0):((change == 1)?(arr2[j]):(arr1[i]));
    }
}
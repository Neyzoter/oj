package cn.neyzoter.oj.array;

public class MiddleOfTwoSortedArrays{
    public static double[] arr1 = {1,2};
    public static double[] arr2 = {3,4};
	public static void main(String[] args){
        System.out.println(Solution1.getMidVal(arr1,arr2));
	}
}

class Solution1{
    public static double getMidVal(double[] arr1,double[] arr2){
        int m = arr1.length;int n = arr2.length;

        int midLen = (m + n +1)/2;int remainder = (m + n + 1)%2;
        if(m==0 && n !=0){
            return (remainder == 1)?((arr2[midLen-1] + arr2[midLen])/2.0):arr2[midLen-1];
        }else if(m!=0 && n ==0){
            return (remainder == 1)?((arr1[midLen-1] + arr1[midLen])/2.0):arr1[midLen-1];
        }else if(m == 1 && n ==1 ){
            return (arr1[0]+arr2[0])/2.0;
        }
        int i = (arr1[0]-arr1[m-1] > 0)?m-1:0;
        int j = (arr2[0]-arr2[n-1] > 0)?n-1:0;
        int inc1 = (arr1[0]-arr1[m-1] > 0)?-1:1;
        int inc2 = (arr2[0]-arr2[n-1] > 0)?-1:1;
        double temp_b = Math.min(arr1[i],arr2[j]);
        double temp_s =0;

        for(int incNum = 0;incNum < (midLen + remainder-1);incNum++){
            if(arr1[i]>arr2[j]){
                if(j+inc2<0 || j+inc2>n-1){
                    temp_s = temp_b;
                    temp_b = arr1[i];
                    i += inc1;
                }else {
                    temp_s = temp_b;
                    temp_b = arr2[j];
                    j += inc2;
                }
                System.out.println("i = "+i+"\tj = "+j);
            }else {
                if(i+inc1<0 || i+inc1>m-1){

                    temp_s = temp_b;
                    temp_b = arr2[j];
                    j += inc2;
                }else {

                    temp_s = temp_b;
                    temp_b = arr1[i];
                    i += inc1;
                }
                System.out.println("i = "+i+"\tj = "+j);
            }
        }
        System.out.println("temp_b = "+temp_b+"\ttemp_s = "+temp_s);
        return (remainder == 1)?((temp_b + temp_s)/2.0):temp_s;
    }
}
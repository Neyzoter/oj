package cn.neyzoter.oj.array;

import java.util.Arrays;

/**
 * 283 移动零
 */
public class MoveZeros {
    public static void main(String[] args){
        int[] vec_in = {1,0,2,3,0,5};
        System.out.println(Arrays.toString(MoveZeros_Solution1.getVec(vec_in)));

    }
}

class MoveZeros_Solution1{
    public static int[] getVec(int[] vec_in){
        int i,j;
        for(i=0,j=0;j< vec_in.length;j++){
            if(vec_in[j] != 0){
                vec_in[i] = vec_in[j];
                i++;
            }
        }
        for(;i<vec_in.length;i++){
            vec_in[i] = 0;
        }
        return vec_in;
    }
}

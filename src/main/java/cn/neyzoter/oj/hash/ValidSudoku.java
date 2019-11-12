package cn.neyzoter.oj.hash;

import java.util.HashSet;
import java.util.List;

/**
 * 36 有效的数独
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board1 = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new Solution1_ValidSudoku().isValidSudoku(board1));
        System.out.println(new Solution1_ValidSudoku().isValidSudoku(board2));
    }
}


class Solution1_ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9){
            return false;
        }
        if (board[0].length != 9){
            return false;
        }
        HashSet<Character> hash_col = new HashSet<>();
        HashSet<Character> hash_row = new HashSet<>();
        HashSet<Character> hash_squ = new HashSet<>();
        for(int i = 0; i < 9 ; i++){
            hash_col.clear();hash_row.clear();hash_squ.clear();
            // 找到第一个方块的基坐标
            int idx_squ_base = i / 3 * 3;
            int idy_squ_base = i % 3 * 3;
            for (int j = 0; j < 9 ; j++){
                // 列
                if (hash_col.contains(board[j][i])){
                    return false;
                }else if (board[j][i] != '.'){
                    hash_col.add(board[j][i]);
                }
                // 行
                if (hash_row.contains(board[i][j])){
                    return false;
                }else if (board[i][j] != '.'){
                    hash_row.add(board[i][j]);
                }

                // 方块
                // 下面是偏移地址
                int idx_squ = idx_squ_base + j / 3;
                int idy_squ = idy_squ_base + j % 3;
                if (hash_squ.contains(board[idx_squ][idy_squ])){
                    return false;
                }else if (board[idx_squ][idy_squ] != '.'){
                    hash_squ.add(board[idx_squ][idy_squ]);
                }
            }
        }
        return true;
    }
}

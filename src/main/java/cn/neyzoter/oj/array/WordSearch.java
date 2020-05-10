package cn.neyzoter.oj.array;


/**
 * 79 单词搜索
 */
public class WordSearch {
    public static void main(String[] args){
        String[] words = {"ABCCED","SEE","ABCB","ESCFBCE","BFCCESEEDASA"};
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println("===  Solution1  ===");
        Solution1_WordSearch solution1_wordSearch = new Solution1_WordSearch();
        for (String word : words){
            System.out.println(word + "\n\t" + solution1_wordSearch.exist(board, word));
        }

        System.out.println("===  Solution2  ===");
        Solution2_WordSearch solution2_wordSearch1 = new Solution2_WordSearch();
        for (String word : words){
            System.out.println(word + "\n\t" + solution2_wordSearch1.exist(board, word));
        }

    }
}

class Solution1_WordSearch {
    public static final char replaceCh = ' ';
    public boolean exist(char[][] board, String word) {
        for (int i = 0;i < board.length;i++){
            for (int j = 0; j < board[0].length;j++){
                if (board[i][j] == word.charAt(0)){
                    if (word.length() == 1){
                        return true;
                    }else{
                        char[][] boardNext = new char[board.length][board[0].length];
                        for (int idx = 0; idx < board.length;idx ++){
                            System.arraycopy(board[idx],0,boardNext[idx],0,board[0].length);
                        }

                        boardNext[i][j] = replaceCh;
                        if (hasChar(boardNext,word.substring(1),i,j)){
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public boolean hasChar(char[][] board, String str, int i,int j){
        char ch = str.charAt(0);
        int thisI;int thisJ;

        Integer[][] indexs = {{},{},{},{}};
        Integer[] idx0 = {i - 1, j};indexs[0] = idx0;
        Integer[] idx1 = {i + 1,j};indexs[1] = idx1;
        Integer[] idx2 = {i,j - 1};indexs[2] = idx2;
        Integer[] idx3 = {i,j + 1};indexs[3] = idx3;
        int circle = 0;
        for (;circle < 4;circle ++ ){
            thisI = indexs[circle][0];thisJ = indexs[circle][1];
            boolean inBound = thisI >= 0 && thisI < board.length &&  thisJ < board[0].length && thisJ >= 0;
            if (inBound){
                if (board[thisI][thisJ] == ch){
                    if (str.length() > 1) {
                        char[][] boardNext = new char[board.length][board[0].length];
                        for (int idx = 0; idx < board.length;idx ++){
                            System.arraycopy(board[idx],0,boardNext[idx],0,board[0].length);
                        }
                        boardNext[thisI][thisJ] = replaceCh;
                        String strNext = str.substring(1);
                        if (hasChar(boardNext,strNext,thisI,thisJ)){
                            return true;
                        }
                    }else {
                        return true;
                    }


                }
            }
        }
        return false;
    }
}

class Solution2_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (hasWord(board, i, j, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasWord(char[][] board, int x, int y, String word, boolean[][] visited) {
        // 结束条件
        if (word.length() == 0) {
            return true;
        }
        boolean outOfBound = x < 0 || y < 0 || x >= board.length || y >= board[0].length;
        if (outOfBound) {
            return false;
        }
        boolean charVisited = visited[x][y];
        if (charVisited) {
            return false;
        }
        // 判断是否可以继续
        if (board[x][y] == word.charAt(0)) {
            visited[x][y] = true;
            String subWord = word.substring(1);
            boolean hasWord = hasWord(board, x - 1, y, subWord, visited) ||
                    hasWord(board, x, y - 1, subWord, visited) ||
                    hasWord(board, x, y + 1, subWord, visited) ||
                    hasWord(board, x + 1, y, subWord, visited);
            visited[x][y] = false;
            return hasWord;
        } else {
            return false;
        }
    }
}

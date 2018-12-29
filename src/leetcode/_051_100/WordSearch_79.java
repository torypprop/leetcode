package leetcode._051_100;

public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] isTo = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
            	if(solve(board, words, 0, isTo, i, j))
            		return true;
            }
        }
        return false;
    }
    
    private boolean solve(char[][] board, char[] words, int posWords, boolean[][] isTo, int posX, int posY) {
    	if(posWords == words.length)
    		return true;
    	if(posX < 0 || posX >= board.length || posY < 0 || posY >= board[0].length || 
    			board[posX][posY] != words[posWords] || isTo[posX][posY] == true) {
    		return false;
    	}
    	isTo[posX][posY] = true;
    	if(solve(board, words, posWords+1, isTo, posX-1, posY))
    		return true;
    	if(solve(board, words, posWords+1, isTo, posX+1, posY))
    		return true;
    	if(solve(board, words, posWords+1, isTo, posX, posY-1))
    		return true;
    	if(solve(board, words, posWords+1, isTo, posX, posY+1))
    		return true;
    	isTo[posX][posY] = false;
    	return false;
    }
}

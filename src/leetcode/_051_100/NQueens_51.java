package leetcode._051_100;

import java.util.*;

public class NQueens_51 {

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];  //³õÊ¼»¯Îªfalse
        solveNQueensRecursive(n, 0, result, board);
    	return result;
    }

	private void solveNQueensRecursive(int n, int i, ArrayList<List<String>> result, boolean[][] board) {
		if(i == n) {
			ArrayList<String> oneResult = changeBoardToList(board);
			result.add(oneResult);
			return;
		}
		for(int j = 0; j < n; j++) {
			if(check(n, board, i, j)) {
				board[i][j] = true;
				solveNQueensRecursive(n, i+1, result, board);
				board[i][j] = false;
			}
		}
		
	}

	private boolean check(int n, boolean[][] board, int i, int j) {
		for(int k = i-1; k >= 0; k--) {
			if(board[k][j]) {
				return false;
			}
		}
		int l = 1;
		for(int k = i-1; k >= 0 && j-l >= 0; k--) {
			if(board[k][j-l]) {
				return false;
			}
			l++;
		}
		l = 1;
		for(int k = i-1; k >= 0 && j+l < n; k--) {
			if(board[k][j+l]) {
				return false;
			}
			l++;
		}
		return true;
	}

	private ArrayList<String> changeBoardToList(boolean[][] board) {
		ArrayList<String> result = new ArrayList<>(board.length);
		for(boolean[] line: board) {
			StringBuilder sb = new StringBuilder();
			for(boolean b: line) {
				if(b) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			result.add(sb.toString());
		}
		return result;
	}
    
    public static void main(String[] args) {
    	//NQueens_51 demo = new NQueens_51();
    	//List<List<String>> result = demo.solveNQueens(8);
    	//System.out.println(result);
    }
}

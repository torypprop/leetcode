package leetcode._051_100;

public class NQueensII_52 {

	public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];  //³õÊ¼»¯Îªfalse
        return solveNQueensRecursive(n, 0, board);
    }

	private int solveNQueensRecursive(int n, int i, boolean[][] board) {
		if(i == n) {
			return 1;
		}
		int num = 0;
		for(int j = 0; j < n; j++) {
			if(check(n, board, i, j)) {
				board[i][j] = true;
				num += solveNQueensRecursive(n, i+1, board);
				board[i][j] = false;
			}
		}
		return num;
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
}

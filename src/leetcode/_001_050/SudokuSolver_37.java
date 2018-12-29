package leetcode._001_050;

public class SudokuSolver_37 {
	
    public void solveSudoku(char[][] board) {
    	solveSudokuRecursive(board, 0);
    }


    
    private boolean solveSudokuRecursive(char[][] board, int pos) { 
    	if(pos == 81) return true;
    	int line = pos / 9;
    	int column = pos % 9;
    	if(board[line][column] != '.') return solveSudokuRecursive(board, pos+1);
    	
    	for(char c = '1'; c <= '9'; c++) {
    		if(!check(board, line, column, c))
    			continue;
    		board[line][column] = c;
    		if(solveSudokuRecursive(board, pos+1))
    			return true;
    		board[line][column] = '.';
    	}
    	
    	return false;
    }



	private boolean check(char[][] board, int line, int column, char c) {
		for(int i = 0; i < 9; i++) {
			if(board[line][i] == c) return false;
		}
		for(int i = 0; i < 9; i++) {
			if(board[i][column] == c) return false;
		}
		int ii = line/3*3;
		int jj = column/3*3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i+ii][j+jj] == c) return false;
			}
		}
		return true;
	}
    
	
	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j] = '.';
			}
		}
		SudokuSolver_37 demo = new SudokuSolver_37();
		demo.solveSudoku(board);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}

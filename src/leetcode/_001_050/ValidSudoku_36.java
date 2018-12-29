package leetcode._001_050;

import java.util.*;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
    	
    	HashSet<Character> set = new HashSet<>();
    	//横行验证
    	for(int i = 0; i < 9; i++) {
    		set.clear();
    		for(int j = 0; j < 9; j++) {
    			if(board[i][j] != '.') {
    				if(set.contains(board[i][j])) {
    					return false;
    				} else {
    					set.add(board[i][j]);
    				}
    			}
    		}
    	}

    	//竖行验证
    	for(int j = 0; j < 9; j++) {
    		set.clear();
    		for(int i = 0; i < 9; i++) {
    			if(board[i][j] != '.') {
    				if(set.contains(board[i][j])) {
    					return false;
    				} else {
    					set.add(board[i][j]);
    				}
    			}
    		}
    	}
    	
    	//.............
    	for(int i = 0; i < 9; i+=3) {
        	for(int j = 0; j < 9; j+=3) {
        		set.clear();
        		for(int ii = 0; ii < 3; ii++) {
            		for(int jj = 0; jj < 3; jj++) {
            			if(board[i+ii][j+jj] != '.') {
            				if(set.contains(board[i+ii][j+jj])) {
            					return false;
            				} else {
            					set.add(board[i+ii][j+jj]);
            				}
            			}
            		}
        		}
        	}
    	}
    	
        return true;
    }
}

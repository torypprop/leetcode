package leetcode._051_100;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int i = 0;
        int j = n-1;
        while(true) {
        	if(matrix[i][j] == target) {
        		return true;
        	} else if(matrix[i][j] <= target) {
        		i++;
        		if(i == m) {
        			return false;
        		}
        	} else {
        		j--;
        		if(j == -1) {
        			return false;
        		}
        	}
        }	
    }
}

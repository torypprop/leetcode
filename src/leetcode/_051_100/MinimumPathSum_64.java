package leetcode._051_100;

public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] data = new int[m][n];
        data[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
        	data[i][0] = data[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++) {
        	data[0][i] = data[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		int min = data[i-1][j] < data[i][j-1] ? data[i-1][j] : data[i][j-1];
    			data[i][j] = grid[i][j] + min;
        	}
        }
        return data[m-1][n-1];
        
    }
}

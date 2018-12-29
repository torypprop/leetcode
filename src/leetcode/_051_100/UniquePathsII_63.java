package leetcode._051_100;

public class UniquePathsII_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] data = new int[m][n];
        for(int i = 0; i < m; i++) {
        	if(obstacleGrid[i][0] == 1) {
        		break;
        	}
        	data[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
        	if(obstacleGrid[0][i] == 1) {
        		break;
        	}
        	data[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] != 1) {
        			data[i][j] = data[i-1][j] + data[i][j-1];
        		}
        	}
        }
        return data[m-1][n-1];
    }
}

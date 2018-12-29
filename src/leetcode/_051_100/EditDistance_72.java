package leetcode._051_100;

public class EditDistance_72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] data = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
        	data[i][0] = i;
        }
        for(int i = 0; i <= n; i++) {
        	data[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
            	if(word1.charAt(i-1) == word2.charAt(j-1)) {
            		data[i][j] = data[i-1][j-1];
            	} else {
            		data[i][j] = Math.min(data[i-1][j-1], Math.min(data[i][j-1], data[i-1][j]))+1;
            	}
            }
        }
    	return data[m][n];
    }
    
    public static void main(String[] args) {
    	EditDistance_72 demo = new EditDistance_72();
    	System.out.println(demo.minDistance("horse", "ros"));
    	System.out.println(demo.minDistance("intention", "execution"));
	}
}

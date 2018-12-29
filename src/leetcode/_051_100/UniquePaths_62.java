package leetcode._051_100;

public class UniquePaths_62 {
	
    public int uniquePaths(int m, int n) {
        long result = 1;
        m--;
        n--;
        int total = m+n;
        int min = m < n ? m : n;
        for(int i = 1, j = total-min+1; i <= min; i++,j++) {
        	result *= j;
        	result /= i;
        }
        return (int)result;
    }
    
    public static void main(String[] args) {
    	UniquePaths_62 demo = new UniquePaths_62();
    	System.out.println(demo.uniquePaths(5, 5));
	}
}

package leetcode._051_100;

public class PermutationSequence_60 {

    public String getPermutation(int n, int k) {
    	int[] data = new int[n];
    	int divide = 1; 
    	for(int i = 0; i < n; i++) {
    		data[i] = i+1;
    		divide *= (i+1);
    	}
    	int m = n;
    	divide /= m;
    	k -= 1;
    	for(int i = 0; i < n-1; i++) {
    		int num = k / divide;
    		k %= divide;
    		int d = data[i+num];
    		for(;num > 0; num--) {
    			data[i+num] = data[i+num-1];
    		}
    		data[i] = d;
    		m--;
    		divide /= m;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < n; i++) {
    		sb.append(data[i]);
    	}
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	PermutationSequence_60 demo = new PermutationSequence_60();
    	System.out.println(demo.getPermutation(3, 3));
	}
}

package leetcode._051_100;

public class SqrtX_69 {

    public int mySqrt(int x) {
    	if(x<=1) return x;
    	double an = 1;
    	double ann = (an + x/an)/2;
    	double sub = Math.abs(ann-an);
    	while(sub > 1e-200) {
    		an = ann;
    		ann = (an + x/an)/2;
    		sub = Math.abs(ann-an);
    	}
    	int from = (int)an-1;
    	int to = from + 1;
    	int res = from;
    	for(int i = from; i <= to; i++) {
    		if(i*i<=x) {
    			res = i;
    		} 
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	SqrtX_69 demo = new SqrtX_69();
    	System.out.println(demo.mySqrt(2147395600));
	}
}

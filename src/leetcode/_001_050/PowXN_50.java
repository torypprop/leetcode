package leetcode._001_050;

public class PowXN_50 {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == Integer.MIN_VALUE) {
        	return 1.0 / (x * myPow(x, -n-1));
        }
        if(n < 0) return 1.0 / myPow(x, -n);
        double tmp = myPow(x, n/2);
        if(n % 2 == 1) {
        	return tmp*tmp*x;
        } else {
        	return tmp*tmp;
        }
    }
}

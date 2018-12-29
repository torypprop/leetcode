package leetcode._051_100;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        if(n <= 2) {
        	return n;
        }
        int num1 = 1;
        int num2 = 2;
        for(n-=2; n>0; n--) {
        	int tmp = num1+num2;
        	num1 = num2;
        	num2 = tmp;
        }
        return num2;
    }
}

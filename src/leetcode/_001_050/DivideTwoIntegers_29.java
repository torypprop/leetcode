package leetcode._001_050;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideTwoIntegers_29 {
	
    public int divide(int dividend, int divisor) {
    	Map<Integer, Integer> map = new HashMap<>();
    	boolean flag;
    	boolean special = false;
    	if (dividend == 0)
    		return 0;
    	if (divisor == 0)
    		return Integer.MAX_VALUE;
    	if (divisor == 1) {
    		return dividend;
    	} else if (divisor == -1) {
    		if (dividend == Integer.MIN_VALUE) {
    			return Integer.MAX_VALUE;
    		} else {
    			return -dividend;
    		}
    	}
    	if (divisor == Integer.MIN_VALUE) {
    		if (dividend == Integer.MIN_VALUE)
    			return 1;
    		else
    			return 0;
    	}
    	if (dividend == Integer.MIN_VALUE) {
    		flag = divisor < 0 ? true : false;
    		dividend = Integer.MAX_VALUE - divisor + 1;
    		special = true;
    	} else if (dividend > 0 && divisor > 0)
    		flag = true;
    	else if (dividend < 0 && divisor < 0)
    		flag = true;
    	else 
    		flag = false;
    	dividend = Math.abs(dividend);
    	divisor = Math.abs(divisor);
    	int ret = 0;
    	int num1 = divisor;
    	int num2 = 1;
    	ArrayList<Integer> lst = new ArrayList<>();
    	
    	
		map.put(num1, num2);
		lst.add(num1);                    //防止溢出，不能如下写
    	while (num1 <= dividend / 2) {    //while (num1 <= dividend) { 
    		num1 += num1;                 //    map.put(num1, num2);
    		num2 += num2;                 //    lst.add(num1);
    		map.put(num1, num2);          //    num1 += num1;
    		lst.add(num1);                //    num2 += num2;
    	}                                 //}
    	
    	
    	
    	Integer[] rank = new Integer[lst.size()];
    	lst.toArray(rank);
//    	for (int i = rank.length -1; i >= 0; i--) {
//    		if (dividend >= rank[i]) {
//    			dividend -= rank[i];
//    			ret += map.get(rank[i]);
//    		}
//    	}
    	int l = 0; 
    	int r = rank.length - 1;
    	while (r >= 0) {
    		int pos = (l + r) / 2;
    		while (l + 1 < r) {
    			if (dividend >= rank[pos]) {
    				l = pos;
    			} else {
    				r = pos - 1;
    			}
    			pos = (l + r) / 2;
    		}
    		if (dividend >= rank[r])
    			pos = r;
    		if (dividend >= rank[pos]) {
				dividend -= rank[pos];
				ret += map.get(rank[pos]);
    		}
			l = 0; 
			r = pos - 1;
    	}
    	if (special) ret ++;
        return flag ? ret : -ret;
    }
    
    
    
    public static void main(String[] args) {
    	DivideTwoIntegers_29 o = new DivideTwoIntegers_29();
//    	System.out.println(o.divide(3, 3));
//    	System.out.println(o.divide(6, 3));
//    	System.out.println(o.divide(9, 3));
//    	System.out.println(o.divide(81, 3));
//    	System.out.println(o.divide(84, 3));
    	System.out.println(o.divide(2147483647, 2));
    }
}

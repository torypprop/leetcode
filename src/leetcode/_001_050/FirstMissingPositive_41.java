package leetcode._001_050;

import java.util.*;

public class FirstMissingPositive_41 {


    public int firstMissingPositive(int[] nums) {
    	HashSet<Integer> set = new HashSet<>();
    	for(int num: nums) {
    		if(num > 0) {
    			set.add(num);
    		}
    	}
    	for(int i = 1; true; i++) {
    		if(!set.contains(i)) {
    			return i;
    		}
    	}
    }
	
	
	public static void main(String[] args) {

	}

}

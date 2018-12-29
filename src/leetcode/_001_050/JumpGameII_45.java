package leetcode._001_050;

import java.util.*;

public class JumpGameII_45 {

    public int jump(int[] nums) {
    	if(nums.length == 1) {
    		return 0;
    	}
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] bushu = new int[nums.length];
        for(int i = 0; i < bushu.length; i++) {
        	bushu[i] = Integer.MAX_VALUE;
        }
        bushu[0] = 0;
        int maxlen = 0;
        list.add(0);  //第一个为位置
        list.add(0);  //第二个为步数
        while(!list.isEmpty()) {
        	int pos = list.removeFirst();
        	int step = list.removeFirst();
        	if(pos + nums[pos] >= nums.length-1) {
        		return step+1;
        	}
        	for(int i = maxlen; i <= pos+nums[pos]; i++) {
        		if(bushu[i] == Integer.MAX_VALUE) {
        			bushu[i] = step+1;
        	        list.add(i);  //第一个为位置
        	        list.add(step+1);  //第二个为步数
        		}
        	}
        	if(maxlen < pos+nums[pos]) {
        		maxlen = pos+nums[pos];
        	}
        }
    	return Integer.MAX_VALUE;
    }
    
    
    public static void main(String[] args) {
    	JumpGameII_45 demo = new JumpGameII_45();
    	int[] nums = {2,3,1,1,4};
    	System.out.println(demo.jump(nums));
    }
}

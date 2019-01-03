package leetcode._051_100;

import java.util.*;

public class LargestRectangleinHistogram_84 {

    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int index = stack.pop();
                int curArea = stack.isEmpty()? i*heights[index] : (i-stack.peek()-1) * heights[index];
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int curArea = stack.isEmpty() ? heights.length*heights[index] : (heights.length-stack.peek()-1)*heights[index];
            max = Math.max(max,curArea);            
        }
        return max;
    }
	 
    public static void main(String[] args) {
    	LargestRectangleinHistogram_84 demo = new LargestRectangleinHistogram_84();
    	Scanner sc = new Scanner(System.in);
    	String[] s = sc.nextLine().split(" ");
    	int[] heights = new int[s.length];
    	for(int i = 0; i < s.length; i++) {
    		heights[i] = Integer.parseInt(s[i]);
    		//System.out.println(heights[i]);
    		
    	}
    	System.out.println(demo.largestRectangleArea(heights));
	}
}

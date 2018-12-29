package leetcode._001_050;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
    	int max = 0;
    	int l = 0;
    	int r = height.length - 1;
    	while (l < r) {
    		int h = height[l] < height[r] ? height[l]: height[r];
    		max = Math.max(max, area(l,r,h));
    		int pos;
    		if (height[l] < height[r]) {
    			pos = l;
    			while (l < r && height[l] <= height[pos]) {
    				l++;
    			}
    		} else {
    			pos = r;
    			while (l < r && height[pos] >= height[r]) {
    				r--;
    			}
    		}
    	}
    	return max;
    }
    public int area(int l, int r, int h) {
    	return (r-l)*h;
    }
}

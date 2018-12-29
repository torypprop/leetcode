package leetcode._001_050;

//8:55-

public class TrappingRainWater_42 {

    public int trap(int[] height) {
		int result = 0;
		int maxPos = 0;
		int[] prePos = new int[height.length];
		for(int i = 1; i < height.length; i++) {
			if(height[i] > height[maxPos]) {
				prePos[i] = maxPos;
				maxPos = i;
			}
		}
		for(int pos = maxPos; pos > 0; pos = prePos[pos]) {
			int num = (pos - prePos[pos] - 1) * height[prePos[pos]];
			for(int i = prePos[pos]+1; i < pos; i++) {
				num -= height[i];
			}
			result += num;
		}
		int pilotPos = maxPos;
		maxPos = height.length-1;
		for(int i = maxPos-1; i >= pilotPos; i--) {
			if(height[i] >= height[maxPos]) {
				prePos[i] = maxPos;
				maxPos = i;
			}
		}
		for(int pos = maxPos; pos < height.length-1; pos = prePos[pos]) {
			int num = (prePos[pos] - pos - 1) * height[prePos[pos]];
			for(int i = prePos[pos]-1; i > pos; i--) {
				num -= height[i];
			}
			result += num;
		}
        return result;
    }
    
    
    public static void main(String[] args) {
    	TrappingRainWater_42 demo = new TrappingRainWater_42();
    	int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(demo.trap(height));
    }
}

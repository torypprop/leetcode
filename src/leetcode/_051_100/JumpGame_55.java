package leetcode._051_100;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
    	if(nums.length == 1) {
    		return true;
    	}
    	int step = 0;
    	int canReach = 0;
    	for(; step <= canReach; step++) {
    		if(step + nums[step] > canReach) {
    			canReach = step + nums[step];
    			if(canReach >= nums.length-1) {
    				return true;
    			}
    		}
    	}
        return false;
    }
}

package leetcode._051_100;

public class RemoveDuplicatesfromSortedArrayII_80 {

    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0) return 0;
    	int fromPos = 0;
    	int toPos = fromPos + 1;
    	int x = 0;
    	while(toPos < nums.length) {
    		if(nums[toPos] == nums[fromPos]) {
    			toPos++;
    		} else {
    			nums[x++] = nums[fromPos];
    			if(toPos-fromPos >= 2)
    				nums[x++] = nums[fromPos];
    	    	fromPos = toPos;
    	    	toPos = fromPos + 1;
    		}
    	}
		nums[x++] = nums[fromPos];
		if(toPos-fromPos >= 2)
			nums[x++] = nums[fromPos];
        return x;
    }
}

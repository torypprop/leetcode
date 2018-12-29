package leetcode._001_050;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
    	if (nums.length == 0)
    		return 0;
    	int i = 0;
    	int j = nums.length - 1;
    	while (i < j) {
    		while (i < j && nums[i] != val)
    			i++;
    		while (i < j && nums[j] == val)
    			j--;
    		if (i < j) {
    			int tmp = nums[i]; 
	    		nums[i] = nums[j];
	    		nums[j] = tmp; 
    		}
    	}
    	return nums[i] != val ? i+1 : i;
    }

}

package leetcode._051_100;

public class SortColors_75 {

    public void sortColors(int[] nums) {
		int red = 0;
		int blue = nums.length-1;  	        
		for(int i=0; i<=blue; i++) {
			if(nums[i] == 0)  {
				int temp = nums[i];
				nums[i] = nums[red];
				nums[red] = temp;
				red++;
			} else if(nums[i] == 2)  {
				int temp = nums[i];
				nums[i] = nums[blue];
				nums[blue] = temp;
				i--;
				blue--;
			}
		}
    }
}

package leetcode._001_050;

//import java.util.ArrayList;
//import java.util.Arrays;

public class NextPermutation_31 {
	
    public void nextPermutation(int[] nums) {
        int pos1;
        int pos2;
        for (pos1 = nums.length -1; pos1 > 0; pos1--) {
        	if (nums[pos1-1] < nums[pos1]) 
        		break;
        }
        pos1--;
        if (pos1 < 0) {
        	int tmp;
        	for (int i = 0; i < nums.length / 2; i++) {
        		tmp = nums[i];
        		nums[i] = nums[nums.length -1 - i];
        		nums[nums.length -1 - i] = tmp;
        	}
        	return;
        } 
        int posNum = nums[pos1];
        for (pos2 = pos1 + 1; pos2 < nums.length - 1; pos2++) {
        	if (nums[pos2+1] <= posNum) 
        		break;
        }
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
        for (int l = pos1 + 1, r = nums.length - 1; l < r; l++, r--) {
        	tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

	public static void main(String[] args) {
//		NextPermutation_31 o = new NextPermutation_31();
//		int[] nums = {1,2,3,4};
//		for (int i = 0; i < 25; i++) {
//			for (int j = 0; j < nums.length; j++)
//				System.out.print(nums[j]);
//			System.out.println();
//			o.nextPermutation(nums);
//		}
		
	}

}

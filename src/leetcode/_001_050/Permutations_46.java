package leetcode._001_050;

import java.util.*;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        permuteRecursive(nums, 0, result);
        return result;
    }

	private void permuteRecursive(int[] nums, int i, LinkedList<List<Integer>> result) {
		if(i == nums.length-1) {
			LinkedList<Integer> list = new LinkedList<>();
			for(int num: nums) {
				list.add(num);
			}
			result.add(list);
			return;
		}
		for(int j = i; j < nums.length; j++) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			permuteRecursive(nums, i+1, result);
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		
	}
}

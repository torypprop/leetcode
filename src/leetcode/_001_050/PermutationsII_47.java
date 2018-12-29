package leetcode._001_050;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        permuteRecursive(nums, 0, result);
        return new LinkedList<List<Integer>>(result);
    }

	private void permuteRecursive(int[] nums, int i, LinkedHashSet<List<Integer>> result) {
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

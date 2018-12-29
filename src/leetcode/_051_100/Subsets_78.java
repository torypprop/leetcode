package leetcode._051_100;

import java.util.*;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		LinkedList<Integer> oneResult = new LinkedList<>();
		solve(nums, 0, result, oneResult);
        return result;
    }

	private void solve(int[] nums, int pos, LinkedList<List<Integer>> result, LinkedList<Integer> oneResult) {

		if(nums.length == pos) {
			result.add(new ArrayList<Integer>(oneResult));
			return;
		}
		solve(nums, pos+1, result, oneResult);
		oneResult.addLast(nums[pos]);
		solve(nums, pos+1, result, oneResult);
		oneResult.removeLast();
	
		
	}
}

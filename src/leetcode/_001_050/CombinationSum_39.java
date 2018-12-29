package leetcode._001_050;

import java.util.*;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	HashSet<List<Integer>> result = new HashSet<>(); 
    	Arrays.sort(candidates);
    	LinkedList<Integer> list = new LinkedList<>();
    	combinationSumRecursive(candidates, target, list,result, 0);
        return new LinkedList<List<Integer>>(result);
    }
    
    private void combinationSumRecursive(int[] candidates, int target, LinkedList<Integer> oneResult, HashSet<List<Integer>> result, int pos) {
    	if(target == 0) {
    		result.add(new LinkedList<Integer>(oneResult));
    	} else if(target < 0) {
    		return;
    	}
    	if(pos == candidates.length)
    		return;
    	combinationSumRecursive(candidates, target, oneResult, result, pos+1);
    	oneResult.addLast(candidates[pos]);
    	combinationSumRecursive(candidates, target-candidates[pos], oneResult, result, pos);
    	oneResult.removeLast();
    }
    
    public static void main(String[] args) {
    	CombinationSum_39 demo = new CombinationSum_39();
    	int[] candidates = new int[] {2, 3, 6, 7};
    	System.out.println(Arrays.toString(demo.combinationSum(candidates, 7).toArray()));
    }
}

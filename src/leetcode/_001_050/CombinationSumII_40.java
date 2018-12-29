package leetcode._001_050;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
    	
    	int num = 1;
    	while(pos+num < candidates.length  && candidates[pos] == candidates[pos+num]) {
    		num++;
    	}
    	for(int i = 0; i <= num; i++) {
    		combinationSumRecursive(candidates, target-candidates[pos]*i, oneResult, result, pos+num);
    		oneResult.addLast(candidates[pos]);
    	}
    	for(int i = 0; i <= num; i++) {
    		oneResult.removeLast();
    	}
    	
//		combinationSumRecursive(candidates, target, oneResult, result, pos+1);
//    	oneResult.addLast(candidates[pos]);
//    	combinationSumRecursive(candidates, target-candidates[pos], oneResult, result, pos+1);
//    	oneResult.removeLast();
    }
    
    public static void main(String[] args) {
    	CombinationSumII_40 demo = new CombinationSumII_40();
    	int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
    	System.out.println(Arrays.toString(demo.combinationSum2(candidates, 8).toArray()));
    	
    	
    	candidates = new int[]{13,23,25,11,7,26,14,11,27,27,26,12,8,20,22,34,27,17,5,26,31,11,16,27,13,20,29,18,7,14,13,15,25,25,21,27,16,22,33,8,15,25,16,18,10,25,9,24,7,32,15,26,30,19};
    	System.out.println(Arrays.toString(demo.combinationSum2(candidates, 25).toArray()));
    }


}

package leetcode._051_100;

import java.util.*;

public class Combinations_77 {
	public List<List<Integer>> combine(int n, int k) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		LinkedList<Integer> oneResult = new LinkedList<>();
		solve(n, k, 1, result, oneResult);
        return result;
    }

	private void solve(int n, int k, int from, LinkedList<List<Integer>> result, LinkedList<Integer> oneResult) {
		if(oneResult.size() == k) {
			result.add(new ArrayList<Integer>(oneResult));
			return;
		}
		if(from > n) {
			return;
		}
		solve(n, k, from+1, result, oneResult);
		oneResult.addLast(from);
		solve(n, k, from+1, result, oneResult);
		oneResult.removeLast();
	}
}

package leetcode._051_100;

import java.util.*;

public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size() == 0) {
    		return new LinkedList<>();
    	}
    	Interval[] arr = new Interval[intervals.size()];
    	intervals.toArray(arr);
    	sort(arr, 0, arr.length-1);
    	LinkedList<Interval> result = new LinkedList<>();
    	int start = arr[0].start;
    	int end = arr[0].end;
    	for(int i = 1; i < arr.length; i++) {
    		if(arr[i].start <= end) {
    			end = arr[i].end > end ? arr[i].end : end;
    		} else {
    			result.add(new Interval(start, end));
    			start = arr[i].start;
    			end = arr[i].end;
    		}
    	}
    	result.add(new Interval(start, end));
        return result;
    }
    

    private int compare(Interval o1, Interval o2) {
		if(o1.start < o2.start) {
			return -1;
		} else if(o1.start > o2.start) {
			return 1;
		} else if(o1.end < o2.end) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public void sort(Interval[] arr, int from, int to) {
		if(from >= to) {
			return;
		}
		int index = patition(arr, from, to);
		sort(arr, from, index-1);
		sort(arr, index+1, to);
	}

	private int patition(Interval[] arr, int from, int to) {
		Interval data = arr[from];
		while(from < to) {
			while(from < to && compare(data, arr[to]) < 0) {
				to--;
			}
			arr[from] = arr[to];
			while(from < to && compare(data, arr[from]) >= 0) {
				from++;
			}
			arr[to] = arr[from];
		}
        arr[from] = data;
		return from;
	}

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args) {
		MergeIntervals_56 demo = new MergeIntervals_56();
		List<Interval> list = new LinkedList<>();
		list.add(new Interval(1, 4));
		list.add(new Interval(1, 4));
		demo.merge(list);
	}
}

package leetcode._051_100;

import java.util.*;


public class InsertInterval_57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	LinkedList<Interval> result = new LinkedList<>();
    	if(intervals.isEmpty()) {
    		result.add(new Interval(newInterval.start, newInterval.end));
    		return result;
    	}
    	boolean isAdd = false;
    	boolean isAdding = false;
    	Iterator<Interval> iter = intervals.iterator();
    	Interval val = iter.next();
    	int start = val.start;
    	int end = val.end;
    	if(newInterval.end < start) {
    		result.add(new Interval(newInterval.start, newInterval.end));
    		result.add(new Interval(start, end));
    		isAdd = true;
    	} else if(end >= newInterval.start) {
    		end = end > newInterval.end ? end : newInterval.end;
    		start = start < newInterval.start ? start : newInterval.start;
    		isAdding = true;
    	} else {
    		result.add(new Interval(start, end));
    	}
    	
    	while(iter.hasNext()) {
    		val = iter.next();
    		if(isAdd) {
    			result.add(new Interval(val.start, val.end));
    		} else if(isAdding){
    			if(val.start <= end) {
    				end = end > val.end ? end : val.end;
    			} else {
    	    		result.add(new Interval(start, end));
    	    		result.add(new Interval(val.start, val.end));
    	    		isAdd = true;
    	    		isAdding = false;
    			}
    		} else {
    	    	start = val.start;
    	    	end = val.end;
    	    	if(newInterval.end < start) {
    	    		result.add(new Interval(newInterval.start, newInterval.end));
    	    		result.add(new Interval(start, end));
    	    		isAdd = true;
    	    	} else if(end >= newInterval.start) {
    	    		end = end > newInterval.end ? end : newInterval.end;
    	    		start = start < newInterval.start ? start : newInterval.start;
    	    		isAdding = true;
    	    	} else {
    	    		result.add(new Interval(start, end));
    	    	}
    		}
    	}
    	if(isAdding) {
    		result.add(new Interval(start, end));
    	}else if(!isAdd) {
    		result.add(new Interval(newInterval.start, newInterval.end));
    	}
        return result;
    }
    
    
    
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}

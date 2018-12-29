package leetcode._001_050;

import java.util.Comparator;  
import java.util.PriorityQueue; 
import java.util.Queue;  


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length == 0)
    		return null;
        Comparator<ListNode> Order =  new Comparator<ListNode>(){  
            public int compare(ListNode o1, ListNode o2) {
                int numbera = o1.val;  
                int numberb = o2.val;  
                if(numberb > numbera)  
                {  
                    return -1;  
                }  
                else if(numberb<numbera)  
                {  
                    return 1;  
                }  
                else  
                {  
                    return 0;  
                } 
            }
        };
        Queue<ListNode> priorityQueue =  new PriorityQueue<ListNode>(lists.length,Order);
        for (ListNode l: lists) {
        	if (l != null) {
        		priorityQueue.add(l);
        	}
        }
        ListNode result = null;
        ListNode p = null, q = null;
    	while (!priorityQueue.isEmpty()) {
    		q = priorityQueue.poll();
    		if (q.next != null) {
    			priorityQueue.add(q.next);
    		}
    		if (result == null) {
    			result = q;
    			p = result;
    		} else {
    			p.next = q;
    			p = p.next;
    		}
    	}
    	return result;
    }

	public static void main(String[] args) {
		MergeKSortedLists_23 a = new MergeKSortedLists_23();
		a.mergeKLists(null);
		a.mergeKLists(new ListNode[0]);
	}

}

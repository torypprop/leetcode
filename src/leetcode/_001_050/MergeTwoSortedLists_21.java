package leetcode._001_050;

public class MergeTwoSortedLists_21 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode h;
    	if (l1 == null)
    		return l2;
    	else if (l2 == null)
    		return l1;
    	if (l1.val < l2.val) {
    		h = l1;
    		l1 = l1.next;
    	} else {
    		h = l2;
    		l2 = l2.next;
    	}
    	ListNode p = h;
    	while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		p.next = l1;
        		l1 = l1.next;
        	} else {
        		p.next = l2;
        		l2 = l2.next;
        	}
        	p = p.next;
    	}
    	p.next = l1 != null ? l1 : l2;
    	return h;
    }
}

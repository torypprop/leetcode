package leetcode._001_050;

public class SwapNodesInPairs_24 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode p1 = head.next.next;
    	ListNode p2 = head;
    	ListNode p3 = head.next;
    	head = p3;
    	ListNode p4 = head;
    	p4.next = p2;
    	p4 = p4.next;
    	while (p1 != null) {
    		p2 = p1;
    		p3 = p2.next;
    		if (p3 != null) {
    			p1 = p3.next;
    			p4.next = p3;
    			p3.next = p2;
    			p4 = p4.next.next;
    		} else {
    			p1 = null;
    			p4.next = p2;
    			p4 = p4.next;
    		}
    	}
    	p4.next = null;
        return head;
    }
}

package leetcode._001_050;

public class ReverseNodesInKGroup_25 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode newHead = null;
    	ListNode p1 = head;
    	ListNode p2;
    	ListNode p3;
    	ListNode p4;
    	ListNode p5;
    	ListNode p6;
    	int i;
    	if (k == 1)
    		return head;
    	for (i = 0; i < k && p1 != null; i++) {
    		p1 = p1.next;
    	}
    	if (i < k) {
    		return head;
    	} else {
    		newHead = head;
    		p3 = head;
    		for (p2 = head.next; p2 != p1; p2 = p4) {
    			p4 = p2.next;
    			p2.next = newHead;
    			newHead = p2;
    		}
    		head = p1;
    		p3.next = null;
    	}
    	while (head != null) {
    		p1 = head;
        	for (i = 0; i < k && p1 != null; i++) {
        		p1 = p1.next;
        	}
        	if (i < k) {
        		p3.next = head;
        		return newHead;
        	} else {
        		p6 = p3;
        		p3 = head;
        		p5 = head;
        		for (p2 = head.next; p2 != p1; p2 = p4) {
        			p4 = p2.next;
        			p2.next = p5;
        			p5 = p2;
        		}
        		head = p1;
        		p6.next = p5;
        		p3.next = null;
        	}
    		
    	}
    	
    	return newHead;
    }
}

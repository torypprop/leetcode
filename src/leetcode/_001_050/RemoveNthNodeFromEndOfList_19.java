package leetcode._001_050;


public class RemoveNthNodeFromEndOfList_19 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n <= 0)
            return head;
    	ListNode p1 = head;
    	ListNode p2 = head;
    	int i;
    	for (i = 0; i < n && p1 != null; i++) {
    		p1 = p1.next;
    	}
    	if (i != n) {
    		return head;
    	}
    	if (i == n && p1 == null)
    		return head.next;
    	while(p1.next != null) {
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	p2.next = p2.next.next;
        return head;
    }
}

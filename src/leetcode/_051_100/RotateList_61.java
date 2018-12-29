package leetcode._051_100;

public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
    	if(k == 0) return head;
        if(head == null) return null;
    	int len = 0;
    	for(ListNode node = head; node != null; node = node.next,len++);
    	k %= len;
    	if(k == 0) return head;
    	ListNode last = head;
    	for(int i = len-k-1; i > 0; i--) last = last.next;
    	ListNode newHead = last.next;
    	last.next = null;
    	for(last = newHead; last.next != null; last = last.next);
    	last.next = head;
        return newHead;
    }
    

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}

package leetcode._001_050;



public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null ) return l2;
    	if (l2 == null ) return l1;
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	while (p1.next != null && p2.next != null) {
    		p1.val += p2.val;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	p1.val += p2.val;
    	p1.next = p1.next != null ? p1.next : p2.next;
    	int flag = 0;
    	for(p1 = l1; ; p1 = p1.next) {
    		int num = p1.val + flag;
    		p1.val = num % 10;
    		flag = num / 10;
    		if (p1.next == null) {
    			if (flag == 1)
    				p1.next = new ListNode(1);
    			break;
    		}
    	}
    	return l1;
    }
    
    private static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }

}

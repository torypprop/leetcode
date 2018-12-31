package leetcode._051_100;


public class RemoveDuplicatesfromSortedList_83 {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode fakehead = new ListNode(0);
		ListNode pNew = fakehead;
		ListNode pHeadPre = null;
		while(head != null) {
			if(pHeadPre == null || (pHeadPre != null && pHeadPre.val != head.val)) {
				pNew.next = head;
				pNew = pNew.next;
			}
			pHeadPre = head;
			head = head.next;	
		}
		pNew.next = null;
		return fakehead.next;
    }
	

    public ListNode addFist(ListNode head, int val) {
    	ListNode newHead = new ListNode(val);
    	newHead.next = head;
    	return newHead;
    }
    
    public void print(ListNode head) {
    	for(; head != null; head = head.next) {
    		System.out.print(" " + head.val);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesfromSortedList_83 demo = new RemoveDuplicatesfromSortedList_83();
    	//1->2->3->3->4->4->5
    	ListNode node = demo.addFist(null, 5);
    	node = demo.addFist(node, 4);
    	node = demo.addFist(node, 4);
    	node = demo.addFist(node, 3);
    	node = demo.addFist(node, 3);
    	node = demo.addFist(node, 2);
    	node = demo.addFist(node, 1);
    	demo.print(node);
    	node = demo.deleteDuplicates(node);
    	demo.print(node);
    	//1->1->2
    	ListNode node2 = demo.addFist(null, 2);
    	node2 = demo.addFist(node2, 1);
    	node2 = demo.addFist(node2, 1);
    	demo.print(node2);
    	node2 = demo.deleteDuplicates(node2);
    	demo.print(node2);
    	//1->1->2->3->3
    	ListNode node3 = demo.addFist(null, 3);
    	node3 = demo.addFist(node3, 3);
    	node3 = demo.addFist(node3, 2);
    	node3 = demo.addFist(node3, 1);
    	node3 = demo.addFist(node3, 1);
    	demo.print(node3);
    	node3 = demo.deleteDuplicates(node3);
    	demo.print(node3);
	}
}

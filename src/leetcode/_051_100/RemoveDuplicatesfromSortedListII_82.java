package leetcode._051_100;

public class RemoveDuplicatesfromSortedListII_82 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	

    public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		ListNode ptr0 = fakehead;
		ListNode ptr1 = fakehead.next;
		ListNode ptr2 = fakehead.next.next;
		boolean flag = false;
		while(ptr2!=null){
			if(ptr1.val == ptr2.val){
				flag = true;
				ptr2 = ptr2.next;
				if(ptr2 == null)
				ptr0.next = null;
			}else{
				if(flag){
					ptr0.next = ptr2;
					flag = false;
				}else{
					ptr0 = ptr1;
				}
				ptr1 = ptr2;
				ptr2 = ptr2.next;
			}
		}
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
    	RemoveDuplicatesfromSortedListII_82 demo = new RemoveDuplicatesfromSortedListII_82();
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
	}
}






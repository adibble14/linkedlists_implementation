public class ListNodeEX extends ListNode {
    public ListNodeEX(int data, ListNode next) {
		super(data, next);
	}

	public static void main(String[] args) {
        ListNode list = new ListNode(42);
        //list.data = 42;
        list.next = new ListNode(-3,list.next);
        //list.next.data = -3;
        list.next.next = new ListNode(17,list.next.next);
        //list.next.next.data = 17;
        //list.next.next.next = null;
        System.out.println(list.data + " " + list.next.data
                           + " " + list.next.next.data);
        // 42 -3 17
        
        ListNode current = list; //prints every value of list
        while (current != null) {
            System.out.println(current.data);
            current = current.next;  // move to next node
        }
        
       
       

    }
}



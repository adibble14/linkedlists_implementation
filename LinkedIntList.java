import java.util.*;

public class LinkedIntList {
	
	private static ListNode front;
	
    public static void main (String args[]) {
        front = new ListNode(42);
        front.next = new ListNode(-3,front.next);
        front.next.next = new ListNode(17,front.next.next);
        
    	int size = size();
    	System.out.println(size);
    	
    	boolean empty = isEmpty();
    	System.out.println(empty);
    	
    	toString(front);
    	
    	int index = indexOF(17);
    	System.out.println(index);
    	
    	boolean contains = contains(-3);
    	System.out.println(contains);
    	
    	clear();   	
    }

    public void add(int value) {
        if (front == null) {
            // adding to an empty list
            front = new ListNode(value);
        } else {
            // adding to the end of an existing list
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }
    
    public void add(int index, int value) {
        if (index == 0) {
            // adding to an empty list
            front = new ListNode(value, front);
        } else {
            // inserting into an existing list
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new ListNode(value,
                                        current.next);
        }
    }
    
    // Adds given value to list in sorted order.
    // Precondition: Existing elements are sorted
    public void addSorted(int value) {
    	if (front == null || value <= front.data) {
    		// insert at front of list
    		front = new ListNode(value, front);
    	}else {
         // insert in middle of list
         ListNode current = front;
         while (current.next != null && 
                current.next.data < value) {
             current = current.next;
         	}
    	}
    }

    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Removes and returns the first value.
    // Throws a NoSuchElementException on empty list.
    public int remove() {
    	if (front == null) {
    		throw new NoSuchElementException();
    	} else {
    		int result = front.data;
    		front = front.next;
    		return result;
    	}
    }
 
    //Removes value at given index from list.
    public void remove(int index) {
    	if (index == 0) {
    		// special case: removing first element
    		front = front.next;
    	} else {
    		// removing from elsewhere in the list
    		ListNode current = front;
    		for (int i = 0; i < index - 1; i++) {
    			current = current.next;
    		}
    		current.next = current.next.next;
    	}
    }
    
    // Returns size of the list.
    public static int size() {
    	int size = 0;
    	ListNode current = front;
    	while(current != null) {
    		size++;
    		current = current.next;
    		
    	}
    	return size;
    }
    
    //Returns true/false if the list is empty.
    public static boolean isEmpty() {
    	if(front != null)
    		return false;
    	else
    		return true;
    }
    
    //Clear the entire list
    public static void clear() {
    	front = null;

    }
    
    //Prints the whole list
    public static void toString(ListNode front) {
        ListNode current = front; 
        System.out.print("(");
        while (current != null) {
            System.out.print(current.data);
            System.out.print(",");
            current = current.next;  
        }
        System.out.println(")");
    }
    
    //Returns the index of that value
    public static int indexOF(int num) {
    	ListNode current = front;
    	int index = 0;
    	while(current.data != num && current != null) {
    		current = current.next;
    		index++;
    	}
    	return index;
    }
    
    //Returns true/false if the value given by user exist in the list.
    public static boolean contains(int value) {
    	ListNode current = front;
    	while(current != null) {
    		if(value == current.data)
    			return true;
    		else
    			current = current.next;
    	}
    	return false;
    }

    
}

class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

}

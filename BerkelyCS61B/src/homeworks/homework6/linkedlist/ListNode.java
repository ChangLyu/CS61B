package homeworks.homework6.linkedlist;
import homeworks.homework6.dict.*;

public class ListNode extends Entry{
	public ListNode next;
	public ListNode prev;
	public ListNode(Object key, Object value){
		this.key=key;
		this.value=value;
		
	}

}

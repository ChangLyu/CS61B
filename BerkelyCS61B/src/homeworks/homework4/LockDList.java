package homeworks.homework4;

public class LockDList extends DList{

	public void lockNode(LockDListNode node) { 
		node.locked =true;
	}
	  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
		    return new LockDListNode(item, prev, next);
		  }


		  public LockDList() {
			  LockDListNode sentinel=newNode(null,null,null);
			  sentinel.prev=sentinel;
			  sentinel.next=sentinel;
			  this.head=sentinel;
			  this.size=0;
		  }

  
		  public void remove(LockDListNode node) {
			  if(node==null||node==head||node.locked==true){
				  return;
			  }else{
				  node.next.prev=node.prev;
				  node.prev.next=node.next;
				  this.size--;
			  }

		  }

	
}

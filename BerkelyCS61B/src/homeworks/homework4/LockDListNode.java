package homeworks.homework4;

public class LockDListNode extends DListNode{
	
    protected boolean locked;
	LockDListNode(Object i, DListNode p, DListNode n) {
		super(i, p, n);
		locked=false;
		// TODO Auto-generated constructor stub
	}

}

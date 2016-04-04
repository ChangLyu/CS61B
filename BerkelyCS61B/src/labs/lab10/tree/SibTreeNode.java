package labs.lab10.tree;

/* SibTreeNode.java */

/**
 *  A SibTreeNode object is a node in a SibTree (sibling-based general tree).
 *  @author Jonathan Shewchuk
 */

class SibTreeNode extends TreeNode {

  /**
   *  (inherited)  item references the item stored in this node.
   *  (inherited)  valid is true if and only if this is a valid node in some
   *               Tree.
   *  myTree references the Tree that contains this node.
   *  parent references this node's parent node.
   *  firstChild references this node's first (leftmost) child.
   *  nextSibling references this node's next sibling.
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  /**
   *  ADT implementation invariants:
   *  1) if valid == true, myTree != null.
   *  2) if valid == true, then this is a descendent of myTree.root.
   *  3) if valid == true, myTree satisfies all the invariants of a
   *     SibTree (listed in SibTree.java).
   */

  protected SibTree myTree;
  protected SibTreeNode parent;
  protected SibTreeNode firstChild;
  protected SibTreeNode nextSibling;

  /**
   * Construct a valid SibTreeNode referring to a given item.
   */
  SibTreeNode(SibTree tree, Object item) {
    this.item = item;
    valid = true;
    myTree = tree;
    parent = null;
    firstChild = null;
    nextSibling = null;
  }

  /**
   * Construct an invalid SibTreeNode.
   */
  SibTreeNode() {
    valid = false;
  }

  /**
   *  children() returns the number of children of the node at this position.
   *  WARNING:  Does not run in constant time.  Actually counts the kids.
   */
  public int children() {
    if (isValidNode()) {
      int count = 0;
      SibTreeNode countNode = firstChild;
      while (countNode != null) {
        count++;
        countNode = countNode.nextSibling;
      }
      return count;
    } else {
      return 0;
    }
  }

  /**
   *  parent() returns the parent TreeNode of this TreeNode.  Throws an
   *  exception if `this' is not a valid node.  Returns an invalid TreeNode if
   *  this node is the root.
   */
  public TreeNode parent() throws InvalidNodeException {
    // REPLACE THE FOLLOWING LINE WITH YOUR SOLUTION TO PART I.
	  if(!isValidNode()){
		  throw new InvalidNodeException();
		  }else if(this.parent==null){
			return new SibTreeNode();
		}else{
			return this.parent;
		}  
  }

  /**
   *  child() returns the cth child of this TreeNode.  Throws an exception if
   *  `this' is not a valid node.  Returns an invalid TreeNode if there is no
   *  cth child.
   */
  public TreeNode child(int c) throws InvalidNodeException {
    if (isValidNode()) {
      if (c < 1) {
        return new SibTreeNode();
      }
      SibTreeNode kid = firstChild;
      while ((kid != null) && (c > 1)) {
        kid = kid.nextSibling;
        c--;
      }
      if (kid == null) {
        return new SibTreeNode();
      } else {
        return kid;
      }
    } else {
      throw new InvalidNodeException();
    }
  }

  /**
   *  nextSibling() returns the next sibling TreeNode to the right from this
   *  TreeNode.  Throws an exception if `this' is not a valid node.  Returns
   *  an invalid TreeNode if there is no sibling to the right of this node.
   */
  public TreeNode nextSibling() throws InvalidNodeException {
    if (isValidNode()) {
      if (nextSibling == null) {
        return new SibTreeNode();
      } else {
        return nextSibling;
      }
    } else {
      throw new InvalidNodeException();
    }
  }

  /**
   *  insertChild() inserts an item as the cth child of this node.  Existing
   *  children numbered c or higher are shifted one place to the right
   *  to accommodate.  If the current node has fewer than c children,
   *  the new item is inserted as the last child.  If c < 1, act as if c is 1.
   *
   *  Throws an InvalidNodeException if "this" node is invalid.
   */
  public void insertChild(Object item, int c) throws InvalidNodeException {
    // FILL IN YOUR SOLUTION TO PART II HERE.
	  if(isValidNode()){
		  if(c<1){ c=1; }
		  if(this.firstChild==null){
			  this.firstChild=new SibTreeNode(this.myTree,item);
			  this.firstChild.parent=this;
			  this.myTree.size++;
		  }else{
			  SibTreeNode pointerNode,pointerNode2;
			  //when c==1, insert into the first child, this situation is different from c>1, considering the connect between parents node and first child node
			  if(c==1){
				  pointerNode=this.firstChild;
				  this.firstChild=new SibTreeNode(this.myTree,item);
				  this.firstChild.parent=this;
				  this.firstChild.nextSibling=pointerNode;
				  this.myTree.size++;
			  }else{	
					  //two situation,first is there are not c number of children in node, other is number of childen is above c
					  pointerNode=(SibTreeNode) this.child(c-1);
					  if(pointerNode.valid==false){
						  pointerNode=this.firstChild;
						  while(pointerNode.nextSibling().valid==true){
							  pointerNode=pointerNode.nextSibling;
						  }
						  pointerNode.nextSibling=new SibTreeNode(this.myTree,item);
						  pointerNode.nextSibling.parent=this;	
						  this.myTree.size++;
					  }else{
						  if(pointerNode.nextSibling().valid==true){
							  pointerNode2=pointerNode.nextSibling;
							  pointerNode.nextSibling=new SibTreeNode(this.myTree,item);
							  pointerNode.nextSibling.parent=this;
							  this.myTree.size++;
							  pointerNode.nextSibling.nextSibling=pointerNode2;
						  }else{
							  pointerNode.nextSibling=new SibTreeNode(this.myTree,item);
							  pointerNode.nextSibling.parent=this;
							  this.myTree.size++;
						  }		 				  
					  }
			  }	  
		  }
		  
	  }else{
		  throw new InvalidNodeException();
	  }
  }

  /**
   *  removeLeaf() removes the node at the current position from the tree if
   *  it is a leaf.  Does nothing if `this' has one or more children.  Throws
   *  an exception if `this' is not a valid node.  If 'this' has siblings to
   *  its right, those siblings are all shifted left by one.
   */
  public void removeLeaf() throws InvalidNodeException {
    // FILL IN YOUR SOLUTION TO PART III HERE.
	  if(this.isValidNode()==true){
		  if(this.child(1).valid==true){
			  return;
		  }else{
			  if(this.parent().valid==false){
				  // this is a root 
				  this.myTree.root=new SibTreeNode();
				  this.valid=false;
				  this.myTree.size--;
				  return;
			  }
			 SibTreeNode pointerNode= this.parent.firstChild;
			 int c=1;
			  while(pointerNode.valid==true){
				  if(pointerNode.hashCode()==this.hashCode()){
					  if(c==1){
						  this.parent.firstChild=pointerNode.nextSibling;
						  this.myTree.size--;
						pointerNode.valid=false;
					  }else{
					((SibTreeNode)(this.parent.child(c-1))).nextSibling=pointerNode.nextSibling;
					this.myTree.size--;
					pointerNode.valid=false;
					  }
				  }else{
					  c++;
				  pointerNode=pointerNode.nextSibling;}
			  }
		  }
		  
	  }else{
		  throw new InvalidNodeException();
	  }
  }

}
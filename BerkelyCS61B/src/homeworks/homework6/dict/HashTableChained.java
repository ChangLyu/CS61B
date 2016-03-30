package homeworks.homework6.dict;
import homeworks.homework6.linkedlist.*;

/* HashTableChained.java */

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	private int width;
	public LinkedList[] linkedlist;
	public int collisionCount;



  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
	  this.width=sizeEstimate;
	  linkedlist= new LinkedList[sizeEstimate];
	  for(int i=0; i<sizeEstimate; i++){
		  linkedlist[i]=new LinkedList(null,0); 
	  }
    // Your solution here.
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
	 this(101);
    // Your solution here.
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
	  
	
	 int result=code%this.width;
	 if(result<0){
		 result=result+this.width;
	 }

    // Replace the following line with your solution.
     return result;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
	  int wholesize=0;
	  for(int i=0; i<this.width;i++){
		  wholesize=wholesize+linkedlist[i].getsize();
	  }
    return wholesize;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
	  for(int i=0;i<this.width;i++){
		  if(this.linkedlist[i].head!=null){
			  return false;
		  }
	  }
    return true;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
	    // Replace the following line with your solution.
	  int index=this.compFunction(key.hashCode());
	  if(this.linkedlist[index].head==null){
		  this.linkedlist[index].head=new ListNode(key,value);
		  linkedlist[index].size++;
		  return linkedlist[index].head;
	  }
	  ListNode pointerNode=this.linkedlist[index].head;
	  while(pointerNode.next!=null){
		  pointerNode=pointerNode.next;
	  }
	  pointerNode.next=new ListNode(key,value);
	  pointerNode.next.prev=pointerNode;
	  linkedlist[index].size++;
	  this.collisionCount++;
      return linkedlist[index].head;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	  int index=this.compFunction(key.hashCode());
	  if(this.linkedlist[index].head==null){
		  return null;
		
	  }else
		  return linkedlist[index].head;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	  int index=this.compFunction(key.hashCode());
	  
	  if(this.linkedlist[index].head==null){
		  return null;
		
	  }

	  ListNode pointerNode=this.linkedlist[index].head;
	
	  while(pointerNode.next!=null){
		  pointerNode=pointerNode.next;
	  }
	  ListNode returnentry=pointerNode;
	  pointerNode.prev.next=null;
	  returnentry.prev=null;
	  linkedlist[index].size--;
      return returnentry;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
	   // Your solution here.
	  for(int i=0;i<this.width;i++){
		  this.linkedlist[i].head=null;
		  linkedlist[i].size=0;
	  }
  }
  // added by myself to prove the right of whole chain
  public String toString(){
	  String str="[";
	  ListNode pointer;
	  for(int i=0;i<this.width;i++){
		  if (this.linkedlist[i].head==null){
			  str=str+"index"+i+":null ,";
		  }else{
			  pointer=this.linkedlist[i].head;
			  str=str+"index"+i+":";
			  while(pointer!=null){
				 str=str+"  key-"+pointer.key+"  value-"+pointer.value+" --> ";
				 pointer=pointer.next;
			  }
			  
		  }
		  str=str+"\n";
	  }
	  return str+"]";
  }
  

}
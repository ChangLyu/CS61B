package homeworks.homework8;
/* ListSorts.java */


import homeworks.homework8.list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
 * @throws QueueEmptyException 
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) throws QueueEmptyException {
    // Replace the following line with your solution.
	  LinkedQueue lq=new LinkedQueue();
	  while(!q.isEmpty()){
	  Object item=q.dequeue(); 
	  LinkedQueue innerlq=new LinkedQueue();
	  innerlq.enqueue(item);
	  lq.enqueue(innerlq);
	  }
	 return lq;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
 * @throws QueueEmptyException 
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) throws QueueEmptyException {
	// Replace the following line with your solution.
	  LinkedQueue lq=new LinkedQueue();
	  Object obj1;
	  Object obj2;
	  
	 if(!q1.isEmpty()&&!q2.isEmpty()){	
		 
	 obj1=  q1.dequeue();	 
	 obj2=  q2.dequeue();
	 
	 do{		 			 
	 if(  ((Integer) obj1).compareTo((Integer) obj2)<0){
		 lq.enqueue(obj1);
		 if(!q1.isEmpty()){
		 obj1= (Integer) q1.dequeue();	}else{
			 lq.enqueue(obj2);
			 break;
		 }	 
	 }else {
		 lq.enqueue(obj2);	
		 if(!q2.isEmpty()){
		 obj2= (Integer) q2.dequeue();}else{
			 lq.enqueue(obj1);
			 break;
		 }
	 }
		 }while(true); 
	 }

	 if(q1.isEmpty()){
		 lq.append(q2);
	 }else{
		 lq.append(q1);
	 }
    return lq;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
 * @throws QueueEmptyException 
   **/
  public static void mergeSort(LinkedQueue q) throws QueueEmptyException {
    // Your solution here.
	  // in java, pass parameter to a function is passed by value,not reference
	  if(q.isEmpty()){
		  return ;
	  }
	  //after finish this, q is empty
	  LinkedQueue lq=makeQueueOfQueues(q);
	  
	  do{
      LinkedQueue newlq=new LinkedQueue();
	  while(!lq.isEmpty()){
		  // q1 is like [1] ,then [1 2] , and [1 2 3 4]
	  LinkedQueue q1=(LinkedQueue) lq.dequeue();
	  if(!lq.isEmpty()){
		  LinkedQueue q2=(LinkedQueue) lq.dequeue();
		  //important, mergeSortedQueues returns queues contains integer, put it into queue[[3,4][5,6]]
		 LinkedQueue i=new LinkedQueue();
		  /*before merge, i is [], after merge  is like [1 2] if q1 is [1] and q2 is [2], i is [[1 2]]
		  enqueue and append is different, one is put the object(here is the queue) as a element, other is 
		 append the content to the end*/
		 i.enqueue(mergeSortedQueues(q1,q2));
		 // newlq is like[[1 2][3 4]]
		  newlq.append(i); 
	  }else{
		  LinkedQueue i=new LinkedQueue();
		 i.enqueue(q1);
		  
		  newlq.append(i);
	  }
	  }
	  lq=newlq;
  }while(lq.size()!=1);
	  //lq is like[[1,2,3,4]]
	  // if you write this, q will pointer to other queue, but itself will not change.
	 /*q=(LinkedQueue) lq.dequeue();*/
	  
	  q.append((LinkedQueue) lq.dequeue());
	  
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String[] args) {

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    try {
		mergeSort(q);
	} catch (QueueEmptyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(q.toString());

    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

    /* Remove these comments for Part III.
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    */
  }

}
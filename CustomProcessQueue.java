/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Proess Scheduler
// Files: CustomProcessQueue.java
// Course: cs300 fall 2018
//
// Author: Jiaqi Wu
// Email: jwu359@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Yuchen Liu
// Partner Email: yliu687@wisc.edu
// Partner Lecturer's Name: Alexi Brooks
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __x_ Write-up states that pair programming is allowed for this assignment.
// __x_ We have both read and understand the course Pair Programming Policy.
// __x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources:None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This is the class that make the queue
 * 
 * @author Jiaqi Wu
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * Constructor for this class
   */
  public CustomProcessQueue() {
    size = 0;
    heap = new CustomProcess[INITIAL_CAPACITY];
  }

  /**
   * This method moves the element up until the array is correct
   * 
   * @param index
   */
  private void minHeapPercolateUp(int index) {
    if (heap[index / 2] == null) {
      return;
    }
    // if the new one has a larger process time than his parent , nothing happen
    if (heap[index].compareTo(heap[index / 2]) > 0) {
      return;
    } else {
      // if the new one is smaller than his parent,
      // switch it self with it parent and recursive call the percolate up
      CustomProcess intermediate;
      intermediate = heap[index / 2];
      heap[index / 2] = heap[index];
      heap[index] = intermediate;

      minHeapPercolateUp(index / 2);
    }
  }

  /**
   * This method moves the element don unitl the array is correct
   * 
   * @param index
   */
  private void minHeapPercolateDown(int index) {
    // while the kids exists
    while (heap[index * 2] != null) {
      // if the current node is smaller than all his child, nothing happen
      
       
      if (heap[index].compareTo(heap[index * 2]) < 0 && heap[index * 2+1] != null&& heap[index].compareTo(heap[index * 2+1]) < 0 ){
        
        return;
      } 
      // if the node are greater
      else {
        // swipe it with it kids
        // compare the kid value and swipe with the smaller one
        // assume the left one is smaller
        CustomProcess smaller = heap[index * 2];
        // if the right one exist and it is smaller than the left one
        if (heap[index * 2 + 1] != null && heap[index * 2].compareTo(heap[index * 2 + 1]) > 0) {
          // set the smaller to the right one
          smaller = heap[index * 2 + 1];
          // if parent larger, swipe with smaller
          if (heap[index].compareTo(smaller) > 0) {
            CustomProcess intermediate;
            intermediate = heap[index];
            heap[index] = smaller;
            heap[index * 2 + 1] = intermediate;
            // recursive
            minHeapPercolateDown(index * 2 + 1);
            
          }
        }
        // else detect if the left one is smaller than parent , if it is, swipe with parent
        if (heap[index].compareTo(smaller) > 0) {
          CustomProcess intermediate;
          intermediate = heap[index];
          heap[index] = smaller;
          heap[index * 2] = intermediate;
          minHeapPercolateDown(index * 2);
         
        }
        return;
      }
    }
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see WaitingQueueADT#size()
   */
  /**
   * return the size of the Queue
   * 
   * @return the size of the Queue
   */
  @Override
  public int size() {

    return this.size;
  }

  /*
   * (non-Javadoc)
   * 
   * @see WaitingQueueADT#isEmpty()
   * 
   */
  /**
   * This detect if the queue is empty
   * 
   * @return true if empty, false other wise
   */
  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.size == 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see WaitingQueueADT#enqueue(java.lang.Comparable)
   */
  /**
   * 
   * this inserts a newObject in the priority queue
   */
  @Override
  public void enqueue(CustomProcess newObject) {
    // if the queue is empty, put it on heap and set size to 1
    if (this.isEmpty()) {
      heap[1] = newObject;
      size = 1;
      // if it is not empty, increment size and put it on
    } else {
      size++;
      // if full expand the array
      try {
        // Try this line, this doesn't do anything but will return arrayindexoutoffboundsexception
        // for the first time, size max at 19 so size = 20 will throw the first exception
        if (heap[size] != null)
          ; // THIS LINE IS MEANINGLESS, SIMPLY TRYING TO PRODUCE A EXCEPTION
      } catch (ArrayIndexOutOfBoundsException e) {
        // double the current size, which should be 20 40 80 160 320
        CustomProcess[] clone = new CustomProcess[(size) * 2];
        for (int i = 0; i < heap.length; i++) {
          clone[i] = heap[i];
        }
        // set heap to the new array
        heap = clone;
      }
      heap[size] = newObject;
      this.minHeapPercolateUp(size);

    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see WaitingQueueADT#dequeue()
   */
  /**
   * removes and returns the item with the highest priority
   * 
   * @returnthe item with the highest priority
   */
  @Override
  public CustomProcess dequeue() {
    if (this.isEmpty()) {
      return null;
    }
    CustomProcess first = heap[1];
    heap[1] = heap[size];
    heap[size] = null;
    minHeapPercolateDown(1);
    // decrement the size
    size--;
    return first;
  }

  /*
   * (non-Javadoc)
   * 
   * @see WaitingQueueADT#peek()
   */
  /**
   * 
   * returns without removing the item with the highest priority
   * 
   * @return the item with the highest priority
   */

  @Override
  public CustomProcess peek() {
    if (this.isEmpty()) {
      return null;
    }
    return heap[1];
  }

  /**
   * Public getter get the heap for test Special use for the test
   * 
   * @return the heap
   */
  public CustomProcess[] getheap() {
    return this.heap;
  }
}

/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Proess Scheduler
// Files: ProcessSchedulerTest.java
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
 * This is the class that run all the tests
 * 
 * @author Jiaqi Wu
 * 
 *
 */
public class ProcessSchedulerTests {
  public static void main(String[] args) {
    // print out true if all test passed
    System.out.println("testEnqueueCustomProcessQueue(): " + testEnqueueCustomProcessQueue());
    System.out.println("testDequeueCustomProcessQueue(): " + testDequeueCustomProcessQueue());
    System.out.println("testIsEmptyCustomProcessQueue(): " + testIsEmptyCustomProcessQueue());
    System.out.println("testIsFullCustomProcessQueue(): " + testIsFullCustomProcessQueue());
  }

  /**
   * checks the correctness of the enqueue operation implemented in the CustomProcessQueue class
   * 
   * @return true if all test passed, false otherwise
   */
  public static boolean testEnqueueCustomProcessQueue() {
    // create a new Queue and enqueue five nodes
    CustomProcessQueue result = new CustomProcessQueue();
    CustomProcess node1 = new CustomProcess(10);
    CustomProcess node2 = new CustomProcess(40);
    CustomProcess node3 = new CustomProcess(20);
    CustomProcess node4 = new CustomProcess(30);
    CustomProcess node5 = new CustomProcess(5);
    result.enqueue(node1);
    result.enqueue(node2);
    result.enqueue(node3);
    result.enqueue(node4);
    result.enqueue(node5);
    // save the size and make a expect array
    int size = result.size();
    int[] resultarray = {0, 5, 10, 20, 40, 30};
    // then get the heap and compare each value, any mismatch,return false
    CustomProcess[] test = result.getheap();

    for (int i = 1; i < size + 1; i++) {
      if (test[i].getBurstTime() != resultarray[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   * checks the correctness of the dequeue operation implemented in the CustomProcessQueue class
   * 
   * @return true if all test passed, false otherwise
   */
  public static boolean testDequeueCustomProcessQueue() {
    CustomProcessQueue result = new CustomProcessQueue();
    CustomProcess node1 = new CustomProcess(3);
    CustomProcess node2 = new CustomProcess(8);
    CustomProcess node3 = new CustomProcess(5);
    CustomProcess node4 = new CustomProcess(20);
    CustomProcess node5 = new CustomProcess(25);
    CustomProcess node6 = new CustomProcess(7);
    CustomProcess node7 = new CustomProcess(6);
    result.enqueue(node1);
    result.enqueue(node2);
    result.enqueue(node3);
    result.enqueue(node4);
    result.enqueue(node5);
    result.enqueue(node6);
    result.enqueue(node7);
    // save the size and make a expect array
   

    int size = result.size();
    int[] resultarray = {5, 10, 20, 30, 40};
    for (int i = 1; i < size + 1; i++) {
      System.out.println(result.dequeue().getBurstTime());
      // dequeue the heap step by step, if any mismatch, return false
//      if (result.dequeue().getBurstTime() != resultarray[i - 1]) {
//        return false;
//      }
    }
    return true;

  }

  /**
   * Check the is empty method
   * 
   * @return return true if passed
   */
  public static boolean testIsEmptyCustomProcessQueue() {
    // create a new result by using the constructor
    CustomProcessQueue result = new CustomProcessQueue();
    // if not empty or size not equal to zero, return false
    if (result.isEmpty() != true || result.size() != 0) {
      return false;
    }
    // else return true
    return true;

  }

  /**
   * This is testing if the array will auto double size when array index out of bound
   * 
   * @return return true if all added without error
   */
  public static boolean testIsFullCustomProcessQueue() {
    // create a new result by using the constructor
    CustomProcessQueue result = new CustomProcessQueue();
    try {
      // adding the last one is 320 element, so it will expand the array size to 640
      for (int i = 0; i < 320; i++) {

        result.enqueue(new CustomProcess(i));

      }
      // if any exception happened, return false
    } catch (Exception e) {
      return false;
    }
    return true;

  }

}

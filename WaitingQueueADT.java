/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Proess Scheduler
// Files: WaitingQueueADT.java
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
 *  This is the parent class of CustomProcessQueue
 *  Providing all the method signature to use 
 * @author Jiaqi Wu
 *
 * @param <T>
 */
public interface WaitingQueueADT<T extends Comparable<T>> {
 
  /**
   * inserts a newObject in the priority queue
   * @param newObject the item that need to be add
   */
  public void enqueue(T newObject);
 
  /**
   *removes and returns the item with the highest priority
   * @return the top item
   */
  public T dequeue(); 
 
  /**
   * returns without removing the item with the highest priority
   * @return the top item
   */
  public T peek(); 
 
  /**
   *returns size of the waiting queue
   * @return the size of the queue
   */
  public int size(); 
 
  /**
   * checks if the waiting queue is empty
   * @return true if empty, false otherwise
   */ 
  public boolean isEmpty(); 
}
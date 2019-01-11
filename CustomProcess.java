/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Proess Scheduler
// Files: CustomProcess.java
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
 * This is the class for custom process and their elements
 * 
 * @author Jiaqi Wu
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {
  private static int nextProcessId = 1; // stores the id to be assigned to the next process
  // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution



  /**
   * This is the constructor for CustomProcess class, it set up the burst time , the process id and
   * increment the next iD
   * 
   * @param burstTime the bursttime for this process
   */
  public CustomProcess(int burstTime) {
    this.burstTime = burstTime;
    this.PROCESS_ID = nextProcessId;
    nextProcessId++;
  }

  /**
   * This is the getter for processId
   * 
   * @return the process id 
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * This is the getter for burst time
   * 
   * @return burst time
   */
  public int getBurstTime() {
    return this.burstTime;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  /**
   * This method is used to compare this CustomProcess to another one (other). Suppose that we have
   * two instances of CustomProcess classes referred by p1 and p2. The process that has higher
   * priority than the other should be run first.
   * 
   * @param other
   * @return the negative if less, positive if larger
   */
  @Override
  public int compareTo(CustomProcess other) {
    // calculate the difference in burst time, smaller one has higher priority
    int result = this.burstTime - other.burstTime;
    if (result == 0) {
      if (this.PROCESS_ID > other.PROCESS_ID) {
        return 1;
      } else {
        return -1;
      }
    }
    return result;
  }
}

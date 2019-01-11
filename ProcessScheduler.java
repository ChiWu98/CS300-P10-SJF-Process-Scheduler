/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Proess Scheduler
// Files: ProcessScheduler.java
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
import java.util.Scanner;

/**
 * This is the ProcessScheduler class that runs the whole program
 * @author Jiaqi Wu
 *
 */
public class ProcessScheduler {
  private int currentTime; // stores theurrent time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * This is the constructor that initialize all the variable
   */
  public ProcessScheduler() {
    currentTime = 0;
    numProcessesRun = 0;
    queue = new CustomProcessQueue();
  }

  /**
   * add a new process
   * @param process
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);
  }

  /**
   * This is the running method for scheduler
   * @return the string for the run process
   */
  public String run() {
    // make a string builder
    StringBuilder run;
    // if the size is less then 1, use process, else use processes
    if (queue.size() <= 1)
      run = new StringBuilder("Starting " + queue.size() + " process\n\n");
    else {
      run = new StringBuilder("Starting " + queue.size() + " processes\n\n");
    }
    // save the queue size
    int size = queue.size();
    // run the process, starting with the smallest burst time and print match information
    for (int i = 0; i < size; i++) {
      run.append("Time " + this.currentTime + " : Process ID " + queue.peek().getProcessId()
          + " Starting.\n");
      // increment num process run and current time
      numProcessesRun++;
      currentTime = currentTime + queue.peek().getBurstTime();
      run.append("Time " + this.currentTime + " : Process ID " + queue.dequeue().getProcessId()
          + " Completed.\n");
      
    }
    // after all finish, print finish information
    run.append("\nTime " + this.currentTime + " : All scheduled processes completed.\n");
    // return the string builder
    return run.toString();
  }



  /**
   * This method display the userMenu
   */
  public void display() {

    System.out.println("Enter command:\r\n" + "[schedule <burstTime>] or [s <burstTime>]\r\n"
        + "[run] or [r]\r\n" + "[quit] or [q]\r\n" + "");
  }

  /**
   * This is the interaction session for userInput
   * 
   * @param sc scanner
   * @return the userInput string
   */
  public String sessionScreen(Scanner sc) {

    // save the userInput as a string

    String userMenuInput = sc.nextLine();
    userMenuInput = userMenuInput.trim().toLowerCase();
    // switch cases based on the user input
    switch (userMenuInput) {
      // if the input is r or run, run the program
      case "r":
      case "run":
        System.out.println(this.run());
        break;
      // if the input is q or quit, return the string
      case "q":
      case "quit":
        break;
      // else check if it is a schedule
      default:
        // split the command based on space
        String[] command = userMenuInput.split(" ");
        // if the command[0] equal to schedule or s
        if (command[0].equals("s") || command[0].equals("schedule ")) {
          int burstTime = 0;
          // try to convert to int, catch numberformat exception
          try {
            burstTime = Integer.parseInt(command[1]);
          } catch (NumberFormatException e) {
            System.out.println("WARNING: burst time MUST be an integer!\n");
            break;
          }
          // if the bursttime < = 0 , print other error message
          if (burstTime <= 0) {
            System.out.println("WARNING: burst time MUST be greater than 0!\n");
            break;
          }
          // if passed the above, make a successful schedule and print the following information
          CustomProcess schedule = new CustomProcess(burstTime);
          // enqueue 
          scheduleProcess(schedule);
          System.out.println("Process ID " + schedule.getProcessId() + " scheduled. Burst Time = "
              + schedule.getBurstTime() + "\n");
          // else the command is not valid
        } else {
          System.out.println("WARNING: Please enter a valid command!\n");
        }

    }
    // return the string
    return userMenuInput;
  }

  /**
   * This is the main class for the method
   * 
   * @param args
   */
  public static void main(String[] args) {
    // initial the process Scheduler
    ProcessScheduler processScheduler = new ProcessScheduler();
    Scanner sc = new Scanner(System.in);
    // print the welcome message
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========\r\n");
    // in a while loop until quit
    while (true) {
      // display the menu
      processScheduler.display();
      // save the command as a string
      String command = processScheduler.sessionScreen(sc);
      // if command equal q or quit, which is the quit command
      if (command.equals("q") || command.equals("quit")) {
        // print the goodbye message
        System.out.println(processScheduler.numProcessesRun + " processes run in "
            + processScheduler.currentTime + " units of time!");
        System.out.println("Thank you for using our scheduler!\r\n" + "Goodbye!");
        break;
      }

    }
  }
}

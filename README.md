This program simulates a round robin CPU scheduling algorithm.

There are four classes: Process.java, Progam.java, Queue.java, and Scheduler.java

Program.java contains the main method which does the following:
  1. Initialize an array of Process Objects
  2. Initialize a scheduler object round robin parameters
  3. The process list is updated with the scheduler.Run() method which simulates round robin scheduling
  4. The final output is exported as a CSV file so it can easily be opened in excel

Scheduler.java contains one method, Run()
  1. This method executes the Round Robin Simulation and outputs a sorted array of processes with their updated values
  2. The Run method has a primary while loop which does the following:
     - Checks to see if there are any arriving processes
     - Checks to see if the ready queue is empty
     - Executes the first item in queue
     - Checks to see if the executed process is done and rewinds time clock if process finished before quantum ended
     - If the executed process is not done, it adds the program back to the queue
     - It checks to see if the next program is different and if so, it adds context switch time to the clock
     - Lastly it increments clock by the quantum amount
  3. After the while loop, the program sorts the processes based on ID
  4. The Run method returns the sorted list of Processes

Process.java is the data structure that is used to simulate the Processes in CPU
- This class has several variable and getters/setters and methods to calculate different metrics

Queue.java is an array based implementation of the Queue data structure that is used in the ReadyQueue in the Scheduler

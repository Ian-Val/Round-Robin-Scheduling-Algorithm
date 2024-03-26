import java.util.ArrayList;
import java.util.Random;

public class RoundRobinScheduler {

    static class Process {
        int processID;
        int serviceTime;
        int timeRemaining;
        int arrivalTime;
        int startTime;
        int endTime;
        int initialWaitTime;
        int totalWaitTime;
        int turnAroundTime;

        // Constructor
        public Process(int processID, int serviceTime, int arrivalTime) {
            this.processID = processID;
            this.serviceTime = serviceTime;
            this.timeRemaining = serviceTime;
            this.arrivalTime = arrivalTime;
            this.startTime = -1; // Set to -1 initially to indicate not started
            this.endTime = -1;   // Set to -1 initially to indicate not finished
            this.initialWaitTime = 0;
            this.totalWaitTime = 0;
            this.turnAroundTime = 0;
        }

        // Override toString method
        @Override
        public String toString() {
            String output = "";
            output += String.format("Process ID: %d\n", processID);
            output += String.format("Service Time: %d\n", serviceTime);
            output += String.format("Arrival Time: %d\n", arrivalTime);
            output += String.format("Start Time: %d\n", startTime);
            output += String.format("End Time: %d\n", endTime);
            output += String.format("Initial Wait Time: %d\n", initialWaitTime);
            output += String.format("Total Wait Time: %d\n", totalWaitTime);
            output += String.format("Turnaround Time: %d\n", turnAroundTime);
            return output;
        }
    }
    public static int clockTime = 0;
    public static void main(String[] args) {
        int numProcesses = 10; // Number of processes
        
        ArrayList<Process> processes = new ArrayList<>();
        Random random = new Random();

        addProcesses(processes, numProcesses, clockTime, random);
        roundRobin(processes);
        // printProcesses(processes);
    }

    private static void addProcesses(ArrayList<Process> processes, int numProcesses, int clockTime, Random random) { // Clock time
        int[] interarrivalTimes = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            interarrivalTimes[i] = random.nextInt(6) + 5; // Generates a random integer from 5 to 10 (inclusive)
        }

        for (int i = 0; i < numProcesses; i++) {
            clockTime += interarrivalTimes[i]; // Increment clock time by interarrival time
            int serviceTime = random.nextInt(5) + 4; // Generates a random integer from 4 to 8 (inclusive)
            processes.add(new Process(i, serviceTime, clockTime)); // Set arrival time as the current clock time
        }
    }

    private static void roundRobin(ArrayList<Process> processes) {
        Queue ReadyQueue = new Queue(5);
        for (Process process : processes) {
            if process.
        }
    }
    

    // private static void printProcesses(ArrayList<Process> processes) {
    //     for (Process process : processes) {
    //         System.out.println(process.toString());
    //     }
    // }
}

import java.util.ArrayList;
import java.util.Random;

class RoundRobin {
    static int numProcesses = 2, finishedProcesses = 0, quantum = 2, contextSwitch = 0, clockTime = 0;
    static Process[] processList;
    static ArrayList<Process> readyQueue = new ArrayList<>();
    public static void main(String[] args) {
        processList = new Process[numProcesses];

        //Create Processes
        for (int i = 0; i < numProcesses; i++) {
            processList[i] = new Process(i);
        }

        //Set Arrival Times
        int arrivalTimeTotal = 0;
        Random rand = new Random(10);
        for (int i = 0; i < numProcesses; i++) {
            processList[i].arrivalTime = arrivalTimeTotal;
            arrivalTimeTotal += rand.nextInt(6) + 5;
        }

        //Set Service Times
        for (int i = 0; i < numProcesses; i++) {
            processList[i].setServiceTime(rand.nextInt(5)+4);
        }

        readyQueue.add(processList[0]);
        //Calculate Start Time and End Time
        for (Process process : processList) {
            process.startTime = process.arrivalTime + 10;
            process.endTime = process.startTime + process.serviceTime;
        }

        RoundRobin(processList, quantum, contextSwitch, clockTime);


        for (Process process : processList) {
            System.out.println(process);
        }
    }
    private static void RoundRobin (Process[]processesList, int quantum, int contextSwitch, int clockTime) {
        ArrayList<Process> readyQueue = new ArrayList<>();
        while (!processesDone(processesList)) {
            for (Process process : processesList) {
                if (process.arrivalTime <= clockTime && process.timeRemaining > 0) {
                    readyQueue.add(process);
                }
            }
            
            while (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.getFirst();
                readyQueue.removeFirst();
                if (currentProcess.startTime == -1) {
                    currentProcess.startTime = clockTime;
                }
                int executionTime = Math.min(quantum, currentProcess.timeRemaining);
                clockTime += executionTime;
                currentProcess.timeRemaining -= executionTime;

                if (currentProcess.timeRemaining == 0) {
                    currentProcess.endTime = clockTime;
                    currentProcess.finished = true;
                }
                System.out.println("InnerLoop");
            }
            clockTime += contextSwitch;
        }
    }
    private static boolean processesDone(Process[]processesList) {
        for (Process process : processesList) {
            if (!process.finished) {
                return false;
            }
        }
        return true;
    }
}

class Process {
    int processId, arrivalTime, serviceTime;
    int startTime, endTime;
    int timeRemaining;
    boolean started = false, finished = false;
    public Process (int processId) {
        this.processId = processId;
    }
    public void setServiceTime (int serviceTime) {
        this.serviceTime = serviceTime;
        this.timeRemaining = serviceTime;
        this.startTime = -1;
    }
    @Override
    public String toString() {
        String output = String.format("Process ID: %d\n",processId);
        output += String.format("Arrival Time: %d\n",arrivalTime);
        output += String.format("Service Time: %d\n",serviceTime);
        output += String.format("Start Time: %d\n",startTime);
        output += String.format("End Time: %d\n",endTime);
        output += "Finished: "+ finished + "\n";
        return output;
    }
}
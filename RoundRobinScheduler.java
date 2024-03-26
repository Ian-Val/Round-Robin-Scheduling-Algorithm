import java.util.ArrayList;
import java.util.Random;

public class RoundRobinScheduler {
    public static int clockTime = 0, quantum = 2, contextSwitch = 0;
    public static int numProcesses = 10, finishedProcesses = 0;
    public static ArrayList<Process> processList = new ArrayList<>(numProcesses);
    public static ReadyQueue queue = new ReadyQueue(200);
    public static Random rand = new Random(155);

    
    public static void AddProcesses() {
        for (int i = 0; i < numProcesses; i++) {
            processList.add(new Process(i,rand.nextInt(5)+4));
        }
    }

    public static void PrintProcesses() {
        for (Process process : processList) { System.out.println(process); }
    }
    public static void generateArrivalTimes() {
        int timeCounter = 0;
        int[] interArrivalTime = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            interArrivalTime[i] = rand.nextInt(6) + 5;
        }
        for (int i = 0; i < processList.size(); i++) {
            processList.get(i).arrivalTime = timeCounter;
            timeCounter += interArrivalTime[i];
        }
    }
    public static void roundRobin(){
        while (finishedProcesses < numProcesses) {
            //Add processes to array only if they arrived

            for (int i = 0; i < processList.size(); i++) {
                if (processList.get(i).arrivalTime <= clockTime) {
                    queue.Enqueue(processList.get(i));
                    //System.out.printf("Process %d is on the queue.\n",processList.get(i).ProcessID);
                }
            }
            Process currentProcess = queue.Dequeue();
            runProcess(currentProcess);
            clockTime += quantum;
            //System.out.printf("Current Time: %d\n",clockTime);
            //System.out.printf("Finished Processes: %d\n",finishedProcesses);
        }
    }

    public static void runProcess(Process currentProcess) {
        if (currentProcess == null) return;

        if (!currentProcess.started) {
            currentProcess.startTime = clockTime;
        }
        currentProcess.timeRemaining -= quantum;
        //System.out.printf("Process %d: Time Remaining = %d\n", currentProcess.ProcessID, currentProcess.timeRemaining);

        if (currentProcess.timeRemaining <= 0) {
            currentProcess.finished = true;
            currentProcess.endTime = clockTime;
            finishedProcesses++;
        }
        else {
            queue.Enqueue(currentProcess);
        }
    }
    public static void main(String[] args) {
        AddProcesses();
        generateArrivalTimes();
        roundRobin();     
        PrintProcesses();
    }
}

import java.util.ArrayList;
import java.util.Random;

public class RoundRobinScheduler {
    public static int clockTime = 0, quantum = 2, contextSwitch = 0;
    public static int numProcesses = 3, finishedProcesses = 0;
    public static ArrayList<Process> processList = new ArrayList<>(numProcesses);
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
        int operatingIndex = 0;
        while (finishedProcesses < numProcesses) {
            //System.out.println(clockTime);
            Process currentProcess = processList.get(operatingIndex);
            if(currentProcess.arrivalTime <= clockTime && !currentProcess.finished) {
                if (!currentProcess.started) {
                    currentProcess.started = true;
                    currentProcess.startTime = clockTime;
                }
                currentProcess.timeRemaining -= quantum;
                if (currentProcess.timeRemaining <= 0){
                    finishedProcesses++;
                    operatingIndex++;
                    currentProcess.endTime = clockTime;
                    currentProcess.finished = false;
                }
            }
            clockTime += quantum;
        }
    }

    public static void runProcess(Process currentProcess) {

    }
    public static void main(String[] args) {
        AddProcesses();
        generateArrivalTimes();
        roundRobin();     
        PrintProcesses();
    }
}

import java.util.ArrayList;

public class Scheduler {
    int clockTime;
    int quantum;
    int contextSwitch;
    ArrayList readyQueue;

    public Scheduler (int quantum, int contextSwitch, ArrayList readyQueue) {
        this.clockTime = 0;
        this.quantum = quantum;
        this.contextSwitch = contextSwitch;
        this.readyQueue = readyQueue;
    }

    public void Run() {
        Process currentProcess;
        currentProcess = (Process)readyQueue.getFirst();
        while (!readyQueue.isEmpty()) {
            if (clockTime < currentProcess.getArrivalTime()) {
                continue;
            }
            System.out.println("Process " + currentProcess.getProcessID() + " is running!");
            currentProcess.ExecuteProcess(quantum, clockTime);
            clockTime += quantum;
            if (currentProcess.getServiceTime() <= 0) {
                readyQueue.remove(currentProcess);
                System.out.println("Process " + currentProcess.getProcessID() + " done!");
            }
            System.out.println("Clock Time: "  + clockTime);

            if (currentProcess == readyQueue.getLast()){
                currentProcess = (Process)readyQueue.getFirst();
                continue;
            }
            if ((Process)readyQueue.get(readyQueue.indexOf(currentProcess) + 1) != null) {
                currentProcess = (Process)readyQueue.get(readyQueue.indexOf(currentProcess) + 1);
            }
        }
        System.out.println("Finished All Processes");
        //Run through all programs with the round robin
        //Print when there is a program running
        //Print when there is a context switch
        //Print when a program ends execution
        //Print when all processes are finished
    }
}

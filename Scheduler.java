public class Scheduler {
    int clockTime;
    int quantum;
    int contextSwitch;
    Queue readyQueue;
    Process[] processes;

    public Scheduler (int quantum, int contextSwitch, Process[] processes) {
        this.clockTime = 0;
        this.quantum = quantum;
        this.contextSwitch = contextSwitch;
        this.processes = processes;
    }

    public Process[] Run() throws Exception{
        readyQueue = new Queue(5);
        Process currentProcess;
        Process[] finishedProcesses = new Process[processes.length];
        int finishedProcessesSize = 0;
        while (clockTime < 250) {
            for (int i = 0; i < processes.length; i++) {
                if (processes[i] != null && processes[i].getArrivalTime() <= clockTime) {
                    readyQueue.Enqueue(processes[i]);
                    processes[i].setStartTime(clockTime);
                    processes[i] = null;
                }
            }
            if (readyQueue.isEmpty()) {
                break;
            }
            currentProcess = readyQueue.Dequeue();
            currentProcess.ExecuteProcess(quantum, clockTime);
            if (currentProcess.getTimeRemaining() <= 0) {
                this.clockTime += currentProcess.getTimeRemaining();
                currentProcess.setEndTime(clockTime);
                //System.out.println(currentProcess);
                finishedProcesses[finishedProcessesSize] = currentProcess;
                finishedProcessesSize++;
            } else {
                readyQueue.Enqueue(currentProcess);
            }
            clockTime += quantum;
        }
        return finishedProcesses;
    }
}

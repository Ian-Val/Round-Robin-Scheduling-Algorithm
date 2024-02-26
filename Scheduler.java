public class Scheduler {
    int clockTime;
    int quantum;
    int contextSwitch;
    Queue readyQueue;
    Process[] processes;

    //Constuctor
    public Scheduler (int quantum, int contextSwitch, Process[] processes) {
        this.clockTime = 0;
        this.quantum = quantum;
        this.contextSwitch = contextSwitch;
        this.processes = processes;
    }

    public Process[] Run() throws Exception{
        //Initialize Variables
        readyQueue = new Queue(5);
        Process currentProcess;
        Process[] finishedProcesses = new Process[processes.length];
        int finishedProcessesSize = 0;

        //
        while (finishedProcessesSize < finishedProcesses.length) {

            //Process Arrival
            for (int i = 0; i < processes.length; i++) {
                if (processes[i] != null && processes[i].getArrivalTime() <= clockTime) {
                    readyQueue.Enqueue(processes[i]);
                    processes[i] = null;
                }
            }

            //Check to see if there are no more Process in Queue
            if (readyQueue.isEmpty()) {
                break;
            }

            //Dequeue and Execute Progam
            currentProcess = readyQueue.Dequeue();
            currentProcess.ExecuteProcess(quantum, clockTime);

            //If the Process is Done, Adjust Clock if needed and add to the finished process array
            if (currentProcess.getTimeRemaining() <= 0) {
                this.clockTime += currentProcess.getTimeRemaining();
                currentProcess.setEndTime(clockTime);
                finishedProcesses[finishedProcessesSize] = currentProcess;
                finishedProcessesSize++;
            } else {
                readyQueue.Enqueue(currentProcess);
            }

            //Increase clock time
            clockTime += quantum;
        }
        //Return the array of processes
         //Sort List
        Process[] sortedList = new Process[finishedProcesses.length];
            for (Process process : finishedProcesses) {
                sortedList[process.getProcessID()-1] = process;
            }
        return sortedList;
    }
}

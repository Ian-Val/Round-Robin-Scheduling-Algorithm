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

    public Process[] Run() {
        //Initialize Variables
        readyQueue = new Queue(15);
        Process currentProcess;
        Process[] finishedProcesses = new Process[processes.length];
        int finishedProcessesSize = 0;

        //
        while (finishedProcessesSize < finishedProcesses.length) {

            //Process Arrival
            for (int i = 0; i < processes.length; i++) {
                if (processes[i] != null && processes[i].getArrivalTime() <= clockTime) {
                    try {
                        if (processes[i].getStartTime() == -1) {
                            processes[i].setStartTime(clockTime);
                        }
                        readyQueue.Enqueue(processes[i]);
                    } catch (Exception e) {
                        System.err.println("Enqueue Error");
                    }
                    
                    processes[i] = null;
                }
            }

            //Check to see if there are no more Process in Queue
            if (readyQueue.isEmpty()) {
                break;
            }

            

            //Dequeue and Execute Progam
            try {
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
                //Check to see if you need to add context switch time
                if (readyQueue.Peek() != null &&currentProcess != readyQueue.Peek()){
                    clockTime += contextSwitch;
                }
            } catch (Exception e) {
                System.err.println("Dequeue Error");
            }
            //Increase clock time
            clockTime += quantum;
        }
        //Return the array of processes

        //Sort List by ID
        Process[] sortedList = new Process[finishedProcesses.length];
            for (Process process : finishedProcesses) {
                if (process != null)
                sortedList[process.getProcessID()] = process;
                else
                continue;
            }
        
        return sortedList;
    }
}

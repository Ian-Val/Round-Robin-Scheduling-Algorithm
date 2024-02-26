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

    public void Run() throws Exception{
        readyQueue = new Queue(5);
        Process currentProcess;
        while (clockTime < 250) {
            //System.out.println("Clock Time: " + clockTime);
            //Set Start Time
            for (int i = 0; i < processes.length; i++) {
                if (processes[i] != null && processes[i].getArrivalTime() <= clockTime) {
                    readyQueue.Enqueue(processes[i]);
                    processes[i].setStartTime(clockTime);
                    processes[i] = null;
                }
            }
            //Execute One Process
            currentProcess = readyQueue.Dequeue();
            //System.out.println("\tP" + currentProcess.getProcessID() + " is executing!");
            //System.out.print("\tP" + currentProcess.getProcessID() + " Time: " + currentProcess.getTimeRemaining() + " => ");
            currentProcess.ExecuteProcess(quantum, clockTime);
            //System.out.println(currentProcess.getTimeRemaining());
            if (currentProcess.getTimeRemaining() <= 0) {
                //System.out.println("\tP" + currentProcess.getProcessID() + " is done!");
                this.clockTime += currentProcess.getTimeRemaining();
                currentProcess.setEndTime(clockTime);
                System.out.println(currentProcess);
            } else {
                readyQueue.Enqueue(currentProcess);
            }
            clockTime += quantum;
            //Add wait time 
        }
        //System.out.println("Finished All Processes");
    }
}

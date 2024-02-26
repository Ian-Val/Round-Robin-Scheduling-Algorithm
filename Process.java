public class Process {

    private int processID;
    private int serviceTime;
    private int arrivalTime;
    private int startTime;
    private int endTime;
    private int totalWaitTime;
    private int turnAroundTime;
    
    
    public Process (int processID, int serviceTime, int arrivalTime) {
        this.processID = processID; 
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
        this.startTime = -1;
    }
    
    public void ExecuteProcess(int quantum, int clockTime) {
        if (startTime == -1) {
            this.startTime = clockTime;
        }
        serviceTime -= quantum;
    }

    public int getServiceTime () {
        return serviceTime;
    }
    public int getProcessID () {
        return processID;
    }
    public int getArrivalTime () {
        return arrivalTime;
    }

    public int CalculateTurnAroundTime () {
        turnAroundTime = endTime - arrivalTime;
        return turnAroundTime;
    }

    @Override
    public String toString() {
        String output = String.format("Process %d\n   Service Time: %d\n   Arrival Time: %d\n", processID, serviceTime, arrivalTime);
        return output;
    }

}

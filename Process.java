public class Process {

    private int processID;
    private int serviceTime;
    private int TimeRemaining;
    private int arrivalTime;
    private int startTime;
    private int endTime;
    private int initialWaitTime;
    private int totalWaitTime;
    private int turnAroundTime;
    
    //Constructor
    public Process (int processID, int serviceTime, int arrivalTime) {
        this.processID = processID; 
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
        this.TimeRemaining = serviceTime;
        this.startTime = -1;
        this.totalWaitTime = 0;
    }
    //Setters
    public void setStartTime(int startTime) {
        this.startTime = startTime;
        CalculateInitialWaitTime();
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
        CalculateTurnAroundTime();
    }
    public void addWaitTime(int waitTime) {
        this.totalWaitTime += waitTime;
    }
    //Getters
    public int getProcessID () {
        return processID;
    }
    public int getServiceTime () {
        return serviceTime;
    }
    public int getTimeRemaining () {
        return TimeRemaining;
    }
    public int getArrivalTime () {
        return arrivalTime;
    }
    public int getStartTime () {
        return startTime;
    }
    public int getEndTime () {
        return endTime;
    }
    public int getInitialWaitTime () {
        return initialWaitTime;
    }
    public int getTotalWaitTime () {
        return totalWaitTime;
    }
    public int getTurnAroundTime () {
        return turnAroundTime;
    }

    //Execution Method
    public void ExecuteProcess(int quantum, int clockTime) {
        if (startTime == -1) {
            this.startTime = clockTime;
        }
        TimeRemaining -= quantum;
    }
    
    //Calculation Methods
    private void CalculateTurnAroundTime () {
        turnAroundTime = endTime - arrivalTime;
        CalculateTotalWaitTime();
    }
    private void CalculateInitialWaitTime () {
        initialWaitTime = startTime - arrivalTime;
    }
    private void CalculateTotalWaitTime () {
        totalWaitTime = turnAroundTime - serviceTime;
    }

    @Override
    public String toString() {
        String output = "";
        output += String.format("Process ID: %d\n", processID);
        output += String.format("Service Time: %d\n", serviceTime);
        output += String.format("Arrival Time: %d\n", arrivalTime);
        output += String.format("Start Time:  %d\n", startTime);
        output += String.format("End Time: %d\n", endTime);
        output += String.format("Initial Wait Time: %d\n", initialWaitTime);
        output += String.format("Total Wait Time: %d\n", totalWaitTime);
        output += String.format("Turnaround Time: %d\n", turnAroundTime);
        return output;
    }
}

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
    
    
    public Process (int processID, int serviceTime, int arrivalTime) {
        this.processID = processID; 
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
        this.TimeRemaining = serviceTime;
        this.startTime = -1;
        this.totalWaitTime = 0;
    }
    
    public void ExecuteProcess(int quantum, int clockTime) {
        if (startTime == -1) {
            this.startTime = clockTime;
        }
        TimeRemaining -= quantum;
    }
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
    public int getTimeRemaining () {
        return TimeRemaining;
    }
    public int getProcessID () {
        return processID;
    }
    public int getArrivalTime () {
        return arrivalTime;
    }
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
        output += String.format("Process ID: %d\n ", processID);
        output += String.format("Service Time: %d\n ", serviceTime);
        output += String.format("Arrival Time: %d\n ", arrivalTime);
        output += String.format("Start Time:  %d\n ", startTime);
        output += String.format("End Time: %d\n ", endTime);
        output += String.format("Initial Wait Time: %d\n ", initialWaitTime);
        output += String.format("Total Wait Time: %d\n ", totalWaitTime);
        output += String.format("Turnaround Time: %d\n ", turnAroundTime);
        return output;
    }
}

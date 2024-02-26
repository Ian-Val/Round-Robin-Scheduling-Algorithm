public class Process {

    private int processID;
    private int serviceTime;
    private int TimeRemaining;
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
        this.TimeRemaining = serviceTime;
    }
    
    public void ExecuteProcess(int quantum, int clockTime) {
        if (startTime == -1) {
            this.startTime = clockTime;
        }
        TimeRemaining -= quantum;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
        CalculateTurnAroundTime();
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
    public void CalculateTurnAroundTime () {
        turnAroundTime = endTime - arrivalTime;
    }
    @Override
    public String toString() {
        String output = "";
        output += String.format("Process ID: %d\n ", processID);
        output += String.format("Service Time: %d\n ", serviceTime);
        output += String.format("Arrival Time: %d\n ", arrivalTime);
        output += String.format("Start Time:  %d\n ", startTime);
        output += String.format("End Time: %d\n ", endTime);
        output += String.format("Total Wait Time: %d\n ", totalWaitTime);
        output += String.format("Turnaround Time: %d\n ", turnAroundTime);
        return output;
    }
}

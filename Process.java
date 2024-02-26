public class Process {

    private int processID;
    private int serviceTime;
    private int arrivalTime;
    
    
    public Process (int processID, int serviceTime, int arrivalTime) {
        this.processID = processID; 
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        String output = String.format("Process %d\n   Service Time: %d\n   Arrival Time: %d\n", processID, serviceTime, arrivalTime);
        return output;
    }
}

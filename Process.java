import java.util.Random;

public class Process {
    int ProcessID, serviceTime, arrivalTime;
    int startTime, endTime;
    int initialWaitTime, totalWaitTime, turnaroundTime;
    int timeRemaining;
    boolean started;
    boolean finished;
    Random rand = new Random(105);
    
    Process (int ProcessID,int serviceTime) {
        this.ProcessID = ProcessID;
        this.serviceTime = serviceTime;
        timeRemaining = serviceTime;
        started = false;
        finished = false;
    }
    @Override
    public String toString() {
        String output = String.format("Process ID: %d\n", ProcessID);
        output += String.format("Arrival Time: %d\n", arrivalTime);
        output += String.format("Service Time: %d\n", serviceTime);

        output += String.format("Start Time: %d\n", startTime);
        output += String.format("End Time: %d\n", endTime);
        return output;
    }
}
    

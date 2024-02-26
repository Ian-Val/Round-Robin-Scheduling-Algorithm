import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Program {
    public static void main(String[] args) {
        Process[] processList = {
            new Process(1, 75, 0),
            new Process(2, 40, 10),
            new Process(3, 25, 10),
            new Process(4, 20, 80),
            new Process(5, 45, 85)
        };
        Scheduler scheduler = new Scheduler(10,0, processList);
        //Run Scheduler Program
        try {
            processList = scheduler.Run();       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Sort ProcessList by ID
        Process[] sortedList = new Process[processList.length];
        for (Process process : processList) {
            sortedList[process.getProcessID()-1] = process;
        }
        BufferedWriter output;
        try {
            output = new BufferedWriter(new FileWriter("output.csv"));
            output.write("Process ID,Service Time,Arrival Time,Start Time,End Time, Initial Wait Time,Total Wait Time,Turnaround Time");
            output.newLine();
            for (Process process : sortedList) {
                output.write(process.getProcessID() + ",");
                output.write(process.getServiceTime() + ",");
                output.write(process.getArrivalTime() + ",");
                output.write(process.getEndTime() + ",");
                output.write(process.getTotalWaitTime() + ",");
                output.write(process.getTurnAroundTime() + "");
                output.newLine();
            }
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //Output Process List
        for (Process process : sortedList) {
            System.out.println(process);
        }



        
    }
}

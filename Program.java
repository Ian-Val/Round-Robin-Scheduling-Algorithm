import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        //Initialize List
        Process[] processList = GenerateProcesses(100);

        //Create new Scheduler
        Scheduler scheduler = new Scheduler(2,1, processList);
        
        //Run Scheduler Program
        processList = scheduler.Run();   

    }

    private static Process[] GenerateProcesses(int numProcesses){
        Process[] output = new Process[numProcesses];
        Random rand = new Random(1000);
        int currentTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            output[i] = new Process(i, rand.nextInt(5)+4,currentTime);
            System.out.println(output[i]);
            currentTime += rand.nextInt(6)+5;
        }
        return output;
    }
}

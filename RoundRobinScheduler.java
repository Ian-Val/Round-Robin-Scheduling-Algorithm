import java.util.ArrayList;

public class RoundRobinScheduler {
    public static int clockTime = 0;
    public static int numProcesses = 10;

    public static class Process {
        int ProcessID;
        Process (int ProcessID) {
            this.ProcessID = ProcessID;
        }
        @Override
        public String toString() {
            String output = String.format("Process ID: %d", ProcessID);
            return output;
        }
    }
    public static void main(String[] args) {
        ArrayList<Process> processList = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            processList.add(new Process(i));
        }

        for (Process process : processList) {
            System.out.println(process);
        }
    }
}

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
        //Output Process List
        for (Process process : sortedList) {
            System.out.println(process);
        }
    }
}

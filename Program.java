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
        try {
            processList = scheduler.Run();       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Process process : processList) {
            System.out.println(process);
        }
    }
}

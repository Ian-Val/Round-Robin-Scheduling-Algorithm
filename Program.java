import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Process> processList = new ArrayList<>();
        processList.add(new Process(1, 75, 0));
        processList.add(new Process(2, 40, 10));
        processList.add(new Process(3, 25, 10));
        processList.add(new Process(4, 20, 80));
        processList.add(new Process(5, 45, 85));

        Scheduler scheduler = new Scheduler(10,0, processList);
        //scheduler.Run();     

        Queue queue = new Queue(5);
        try {
            queue.Enqueue(1);
            queue.Enqueue(2);
            queue.Enqueue(3);
            queue.Enqueue(4);
            queue.Enqueue(5);
            queue.PrintQueue();
            queue.Dequeue();
            queue.PrintQueue();
            queue.Enqueue(6);
            queue.PrintQueue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }
}

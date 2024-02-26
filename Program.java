public class Program {
    public static void main(String[] args) {
        Process p1 = new Process(1, 10, 20);
        
        Scheduler scheduler = new Scheduler(10,0);
        System.out.println(p1);
    }
}

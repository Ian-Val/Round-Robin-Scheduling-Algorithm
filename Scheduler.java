import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scheduler {
    int clockTime;
    int quantum;
    int contextSwitch;
    private Queue<Process> requestQueue = new PriorityQueue();

    public Scheduler (int quantum, int contextSwitch) {
        this.clockTime = 0;
        this.quantum = quantum;
        this.contextSwitch = contextSwitch;
    }

    public void AddToRequestQueue(Process processToAdd) {
        requestQueue.add(processToAdd);
    }

    public void RunPrograms(){
        while(!requestQueue.isEmpty()) {
            requestQueue.poll()
        }
    }
}

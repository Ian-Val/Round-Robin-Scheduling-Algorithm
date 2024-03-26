public class ReadyQueue {
    int capacity;
    int size;
    Process[] Queue;

    //Constructor
    public ReadyQueue (int capacity) {
        this.capacity = capacity;
        this.size = 0;
        Queue = new Process[capacity];
    }

    //Peek
    public Process Peek() throws Exception {
        if(isEmpty()) {
            return null;
        }
        Process peekedItem = Queue[0];

        return peekedItem;
    }

    //Enqueue
    public void Enqueue(Process newItem){
        if (this.size == this.capacity) {
            System.err.println("The Queue is Full");
            return;
        }
        Queue[size] = newItem;
        size++;
    }
    //Dequeue
    public Process Dequeue(){
        if(isEmpty()) {
            System.err.println("The Queue is Empty");
            return null;
        }
        Process removedItem = Queue[0];

        for (int i = 0; i < Queue.length - 1; i++) {
            Process temp = Queue[i + 1];
            Queue[i] = temp;
        }
        Queue[size-1] = null;

        size--;
        return removedItem;
    }

    public boolean Contains(Process process) {
        for (int i = 0; i < Queue.length; i++) {
            if (process == null || this.Queue[i] == null) return false;
            if (process.ProcessID == this.Queue[i].ProcessID);
            return true;
        }
        return false;
    }
    //Print Queue
    public void PrintQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("The Queue is Empty");
        }
        System.out.print("{ ");
        for (Process item : Queue) {
            System.out.print(item + " ");
        }
        System.out.println("}");
    }

    //Check isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
}



public class Queue {
    int capacity;
    int size;
    Process[] Queue;

    //Constructor
    public Queue (int capacity) {
        this.capacity = capacity;
        this.size = 0;
        Queue = new Process[capacity];
    }

    //Peek
    public Process Peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("The Queue is Empty");
        }
        Process peekedItem = Queue[0];

        return peekedItem;
    }

    //Enqueue
    public void Enqueue(Process newItem) throws Exception{
        if (this.size == this.capacity) {
            throw new Exception("The Queue is Full");
        }
        Queue[size] = newItem;
        size++;
    }
    //Dequeue
    public Process Dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("The Queue is Empty");
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



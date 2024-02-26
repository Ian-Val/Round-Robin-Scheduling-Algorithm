public class Queue {
    int capacity;
    int size;
    int[] Queue;

    public Queue (int capacity) {
        this.capacity = capacity;
        this.size = 0;
        Queue = new int[capacity];
    }
    //Enqueue
    public void Enqueue(int newItem) throws Exception {
        if (this.size == this.capacity) {
            throw new Exception("Bruh The Queue is Full");
        }
        Queue[size] = newItem;
        size++;
    }


    //Dequeue
    public int Dequeue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Bruh The Queue is Empty");
        }
        int removedItem = Queue[0];

        for (int i = 0; i < Queue.length - 1; i++) {
            int temp = Queue[i + 1];
            Queue[i] = temp;
        }
        Queue[size-1] = -1;

        size--;
        return removedItem;
    }

    //Print Queue
    public void PrintQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Bruh The Queue is Empty");
        }
        System.out.print("{ ");
        for (int item : Queue) {
            System.out.print(item + " ");
        }
        System.out.println("}");
    }

    //Check isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

}



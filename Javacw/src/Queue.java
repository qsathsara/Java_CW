public class Queue {
    private final int SIZE = 8;
    private final Cabin[] cabinQueue = new Cabin[SIZE];
    private int front, rear;

    // Creating a queue with cabins initialized with "e"
    public Queue() {
        front = -1;//f
        rear = -1;//r

        for (int i = 0; i < cabinQueue.length; i++) {
            cabinQueue[i] = new Cabin(i,"e");
        }
    }

    boolean isFull() {
        return front == 0 && rear == SIZE - 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    // Add elements into stack
    public Cabin push() {
        if (front == -1)
            front = 0;
        rear++;
        return cabinQueue[rear];
    }

    // Remove element from stack
    public Cabin pop() {
        Cabin element;
        element = cabinQueue[front];
        if (front >= rear) {
            //remove last element
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        return (element);
    }
}

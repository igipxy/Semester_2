public class QueueLinkedList11 {
    NodeQueue11 front;
    NodeQueue11 rear;
    int size;
    int max; // 0 = unlimited

    public QueueLinkedList11() {
        this.max = 0;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public QueueLinkedList11(int max) {
        this.max = max;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        if (max == 0) return false;
        return size == max;
    }

    void enqueue(Student11 std) {
        if (isFull()) {
            System.out.println("Queue is full!!");
            return;
        }
        NodeQueue11 newNode = new NodeQueue11(std, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(std.name + " has joined the queue.");
    }

    Student11 dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return null;
        }
        Student11 temp = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        System.out.println(temp.name + " is being served.");
        return temp;
    }

    void peekFront() {
        if (!isEmpty()) {
            System.out.println("First student in queue:");
            front.data.print();
        } else {
            System.out.println("Queue is empty!!");
        }
    }

    void peekRear() {
        if (!isEmpty()) {
            System.out.println("Last student in queue:");
            rear.data.print();
        } else {
            System.out.println("Queue is empty!!");
        }
    }

    void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Queue has been cleared.");
    }

    void displayTotal() {
        System.out.println("Total students in queue: " + size);
    }

    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
        } else {
            System.out.println("Queue list:");
            NodeQueue11 temp = front;
            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
        }
    }
}
public class StudentQueue11 {
    // Attributes - now stores Student objects instead of int
    Student11[] data;
    int front, rear, size, max;

    // Constructor
    public StudentQueue11(int n) {
        max = n;
        data = new Student11[max];
        size = 0;
        front = 0;      // Different from Experiment 1: starts at 0
        rear = -1;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    boolean isFull() {
        return size == max;
    }

    // Add student to rear (simplified using modulo)
    void enqueue(Student11 dt) {
        if (isFull()) {
            System.out.println("Queue is full!!!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = dt;
        size++;
        System.out.printf("%s is successfully added at index %d\n", dt.name, rear);
    }

    // Remove and return student from front (simplified using modulo)
    Student11 dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return null;
        }
        Student11 dt = data[front];
        front = (front + 1) % max;
        size--;
        return dt;
    }

    // Display front student
    void peek() {
        if (!isEmpty()) {
            System.out.println("Front data: ");
            data[front].print();
        } else {
            System.out.println("Queue is empty!!!");
        }
    }

    // Display all students
    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return;
        }
        int i = front;
        while (i != rear) {
            data[i].print();
            i = (i + 1) % max;
        }
        data[i].print();
        System.out.println("Number of element: " + size);
    }

    // Clear queue
    void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Queue has been cleared!");
        } else {
            System.out.println("Queue is already empty!!!");
        }
    }
}
public class KRSQueue11 {
    KRSStudent11[] data;
    int front, rear, size, max;
    int totalApproved; // Track how many students have been approved

    public KRSQueue11(int n) {
        max = n;
        data = new KRSStudent11[max];
        size = 0;
        front = 0;
        rear = -1;
        totalApproved = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void enqueue(KRSStudent11 dt) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more students.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = dt;
        size++;
        System.out.println(dt.name + " has joined the KRS approval queue.");
    }

    // Process 2 students at a time
    void processApproval() {
        if (isEmpty()) {
            System.out.println("No students in queue to process.");
            return;
        }
        
        int processCount = Math.min(2, size); // Process up to 2, or whatever is available
        
        System.out.println("\n--- Processing KRS Approval ---");
        for (int i = 0; i < processCount; i++) {
            KRSStudent11 student = data[front];
            System.out.println("Approved: " + student.name + " (" + student.nim + ")");
            front = (front + 1) % max;
            size--;
            totalApproved++;
        }
        System.out.println("-------------------------------\n");
        
        if (isEmpty()) {
            front = 0;
            rear = -1;
        }
    }

    void peek() {
        if (!isEmpty()) {
            System.out.println("First in queue:");
            data[front].print();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    // Show first 2 students
    void peekFirstTwo() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("First two students in line:");
        int count = Math.min(2, size);
        int i = front;
        for (int j = 0; j < count; j++) {
            System.out.print((j + 1) + ". ");
            data[i].print();
            i = (i + 1) % max;
        }
    }

    // Show last student
    void peekLast() {
        if (!isEmpty()) {
            System.out.println("Last student in queue:");
            data[rear].print();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("=== All Students in Queue ===");
        int i = front;
        int num = 1;
        while (i != rear) {
            System.out.print(num + ". ");
            data[i].print();
            i = (i + 1) % max;
            num++;
        }
        System.out.print(num + ". ");
        data[i].print();
        System.out.println("Total in queue: " + size);
        System.out.println("=============================\n");
    }

    void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Queue has been cleared.");
        } else {
            System.out.println("Queue is already empty.");
        }
    }

    // Total students currently in queue
    int getQueueSize() {
        return size;
    }

    // Total students who have completed approval
    int getTotalApproved() {
        return totalApproved;
    }

    // Students who haven't completed (still in queue)
    int getRemaining() {
        return size;
    }

    // Overall students (approved + remaining) - max 30 per DPA
    int getTotalStudents() {
        return totalApproved + size;
    }
}
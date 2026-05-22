package P13;

public class DoubleLinkedLists {
    Node head;
    Node tail;

    DoubleLinkedLists() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    // ==========================================
    // EXPERIMENT 1 METHODS
    // ==========================================

    void addFirst(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void insertAfter(String key, Student data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                if (temp == tail) {
                    addLast(data);
                } else {
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }
                return; // FIX: Exit the method once inserted so it doesn't trigger the "not found" error.
            }
            temp = temp.next;
        }
        // This will only trigger if the loop finishes without finding the key
        System.out.println("Insertion failed. Data (" + key + ") not found!!");
    }

    void print() {
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Double linked list is currently empty!!");
        }
    }

    // ==========================================
    // EXPERIMENT 2 METHODS
    // ==========================================

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void remove(int index) {
        // FIX: Added boundary checks for negative index or exceeding size
        if (index < 0 || index >= getSize()) {
            System.out.println("Removal failed: Index out of bounds!");
            return;
        }

        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            if (temp == tail) {
                removeLast();
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }

    // ==========================================
    // ASSIGNMENT METHODS (12.5)
    // ==========================================

    // 1. Add at specific index
    void add(Student data, int index) {
        if (index < 0 || index > getSize()) {
            System.out.println("Insertion failed: Index out of bounds!");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == getSize()) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    // 2. Remove after a specific key
    void removeAfter(String key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                if (temp.next == null) {
                    System.out.println("No node exists after " + key + " to remove.");
                } else if (temp.next == tail) {
                    removeLast();
                } else {
                    Node nodeToRemove = temp.next;
                    temp.next = nodeToRemove.next;
                    nodeToRemove.next.prev = temp;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Removal failed. Data (" + key + ") not found!!");
    }

    // 3. Get First, Last, and Index
    Student getFirst() {
        if (isEmpty()) return null;
        return head.data;
    }

    Student getLast() {
        if (isEmpty()) return null;
        return tail.data;
    }

    Student getIndex(int index) {
        if (index < 0 || index >= getSize() || isEmpty()) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // 4. Get Size
    int getSize() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 5. Index Of
    int indexOf(String key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1; // Return -1 if not found
    }
}
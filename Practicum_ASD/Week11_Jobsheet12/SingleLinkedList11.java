public class SingleLinkedList11 {
    Node11 head;
    Node11 tail;

    boolean isEmpty() {
        return (head == null);
    }

    void print() {
        if (!isEmpty()) {
            Node11 tmp = head;
            System.out.println("LinkedList Data:");
            while (tmp != null) {
                tmp.data.print();
                tmp = tmp.next;
            }
        } else {
            System.out.println("LinkedList is empty!!");
        }
    }

    void addFirst(Student11 std) {
        Node11 newNode = new Node11(std, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addLast(Student11 std) {
        Node11 newNode = new Node11(std, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void insertAfter(Student11 std, String key) {
        Node11 newNode = new Node11(std, null);
        Node11 temp = head;
        do {
            if (temp.data.name.equalsIgnoreCase(key)) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, Student11 std) {
        if (index < 0) {
            System.out.println("Wrong index!!");
        } else if (index == 0) {
            addFirst(std);
        } else {
            Node11 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node11(std, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    
    Student11 getData(int idx) {
        if (isEmpty()) {
            System.out.println("LinkedList is empty!!");
            return null;
    }
    Node11 tmp = head;
    for (int i = 0; i < idx; i++) {
        tmp = tmp.next;
    }
    return tmp.data;
}

int indexOf(String key) {
    if (isEmpty()) {
        System.out.println("LinkedList is empty!!");
        return -1;
    }
    Node11 tmp = head;
    int idx = 0;
    while (tmp != null && !tmp.data.name.equalsIgnoreCase(key)) {
        tmp = tmp.next;
        idx++;
    }
    if (tmp == null) {
        return -1;
    } else {
        return idx;
    }
}

void removeFirst() {
    if (isEmpty()) {
        System.out.println("LinkedList is empty!!");
    } else if (head == tail) {
        head = tail = null;
    } else {
        head = head.next;
    }
}

void removeLast() {
    if (isEmpty()) {
        System.out.println("LinkedList is empty!!");
    } else if (head == tail) {
        head = tail = null;
    } else {
        Node11 tmp = head;
        while (tmp.next != tail) {
            tmp = tmp.next;
        }
        tmp.next = null;
        tail = tmp;
    }
}

public void remove(String key) {
    if (isEmpty()) {
        System.out.println("LinkedList is empty!!");
    } else {
        Node11 temp = head;
        while (temp != null) {
            if ((temp.data.name.equalsIgnoreCase(key)) && (temp == head)) {
                removeFirst();
                break;
            } else if (temp.next.data.name.equalsIgnoreCase(key)) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
                break;
            }
            temp = temp.next;
        }
    }
}

public void removeAt(int index) {
    if (index == 0) {
        removeFirst();
    } else {
        Node11 temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp;
        }
    }
}
    
    
    
    
    
    }
}
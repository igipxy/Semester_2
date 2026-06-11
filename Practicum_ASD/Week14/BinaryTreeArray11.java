package Practicum_ASD.Week14;

public class BinaryTreeArray11 {
    Student11[] data;
    int idxLast;

    public BinaryTreeArray11() {
        data = new Student11[10];
        idxLast = -1;
    }

    void populateData(Student11[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                data[idxStart].print();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }

    // ========== ASSIGNMENT 4: Add method ==========
    void add(Student11 data) {
        if (idxLast + 1 < this.data.length) {
            idxLast++;
            this.data[idxLast] = data;
        } else {
            System.out.println("Tree array is full!");
        }
    }

    // ========== ASSIGNMENT 4: Pre-order traversal ==========
    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                data[idxStart].print();
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    }
}
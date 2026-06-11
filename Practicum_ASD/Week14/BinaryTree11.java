package Practicum_ASD.Week14;

public class BinaryTree11 {
    Node11 root;

    public BinaryTree11() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Non-recursive add (from experiment)
    public void add(Student11 data) {
        if (isEmpty()) {
            root = new Node11(data);
        } else {
            Node11 current = root;
            while (true) {
                if (data.ipk < current.data.ipk) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node11(data);
                        break;
                    }
                } else if (data.ipk > current.data.ipk) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node11(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    // ========== ASSIGNMENT 1: Recursive Add ==========
    public void addRekursif(Student11 data) {
        root = addRekursif(root, data);
    }

    private Node11 addRekursif(Node11 current, Student11 data) {
        if (current == null) {
            return new Node11(data);
        }
        if (data.ipk < current.data.ipk) {
            current.left = addRekursif(current.left, data);
        } else if (data.ipk > current.data.ipk) {
            current.right = addRekursif(current.right, data);
        }
        return current;
    }

    public boolean find(double ipk) {
        boolean result = false;
        Node11 current = root;
        while (current != null) {
            if (current.data.ipk == ipk) {
                result = true;
                break;
            } else if (ipk < current.data.ipk) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    public void traversePreOrder(Node11 node) {
        if (node != null) {
            node.data.print();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node11 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.data.print();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node11 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.data.print();
        }
    }

    Node11 getSuccessor(Node11 del) {
        Node11 successor = del.right;
        Node11 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node11 parent = root;
        Node11 current = root;
        boolean isLeftChild = false;
        while (current.data.ipk != ipk) {
            parent = current;
            if (ipk < current.data.ipk) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                System.out.println("Couldn't find data!");
                return;
            }
        }
        // delete node with no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) { // delete node with a left child
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // delete node with a right child
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else { // delete node with 2 children
            Node11 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    // ========== ASSIGNMENT 2: Get Min & Max IPK ==========
    public void getMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node11 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Student with minimum IPK:");
        current.data.print();
    }

    public void getMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node11 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Student with maximum IPK:");
        current.data.print();
    }

    // ========== ASSIGNMENT 3: Display students with IPK above threshold ==========
    public void displayStudentsWithIPKAbove(double threshold) {
        System.out.println("Students with IPK above " + threshold + ":");
        displayStudentsWithIPKAbove(root, threshold);
    }

    private void displayStudentsWithIPKAbove(Node11 node, double threshold) {
        if (node != null) {
            displayStudentsWithIPKAbove(node.left, threshold);
            if (node.data.ipk > threshold) {
                node.data.print();
            }
            displayStudentsWithIPKAbove(node.right, threshold);
        }
    }
}
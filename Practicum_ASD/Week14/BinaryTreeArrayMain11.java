package Practicum_ASD.Week14;

public class BinaryTreeArrayMain11 {
    public static void main(String[] args) {
        BinaryTreeArray11 bta = new BinaryTreeArray11();
        Student11 m1 = new Student11("244107020138", "Devin", "TI-1I", 3.57);
        Student11 m2 = new Student11("244107020023", "Dewi", "TI-1I", 3.85);
        Student11 m3 = new Student11("244107020225", "Wahyu", "TI-1I", 3.21);
        Student11 m4 = new Student11("244107020076", "Angelina", "TI-1I", 3.54);
        Student11 m5 = new Student11("244107020223", "Andhika", "TI-1I", 3.72);
        Student11 m6 = new Student11("244107020226", "Bima", "TI-1I", 3.37);
        Student11 m7 = new Student11("244107020181", "Eiyu", "TI-1I", 3.46);

        Student11[] data = {m1, m2, m3, m4, m5, m6, m7};
        bta.populateData(data, data.length - 1);
        System.out.println("In-order traversal:");
        bta.traverseInOrder(0);

        // ========== DEMONSTRATE ASSIGNMENT METHODS ==========
        System.out.println("\n--- Demonstrate add() method ---");
        bta.add(new Student11("244107020111", "Fajar", "TI-1I", 3.65));
        bta.add(new Student11("244107020112", "Gita", "TI-1I", 3.88));
        System.out.println("In-order traversal after add:");
        bta.traverseInOrder(0);

        System.out.println("\n--- Demonstrate Pre-order traversal ---");
        bta.traversePreOrder(0);
    }
}
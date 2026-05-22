package P13;

public class DoubleLinkedListsMain {
    public static void main(String[] args) {
        DoubleLinkedLists dll = new DoubleLinkedLists();

        System.out.println("======================================");
        System.out.println("       EXPERIMENT 1: INSERTION        ");
        System.out.println("======================================");
        dll.print();
        
        dll.addFirst(new Student("111", "Anton", "TI-1I", 3.57));
        dll.print();
        
        dll.addLast(new Student("112", "Prabowo", "TI-1I", 3.7));
        dll.print();
        
        dll.addFirst(new Student("113", "Herco", "TI-1I", 3.89));
        dll.print();
        
        dll.insertAfter("111", new Student("114", "Rizki", "TI-1I", 3.8));
        dll.print();
        
        dll.insertAfter("112", new Student("115", "Hanzel", "TI-1I", 3.6));
        dll.print();
        
        dll.insertAfter("120", new Student("116", "Eiyu", "TI-1I", 3.4));
        dll.print();

        System.out.println("======================================");
        System.out.println("       EXPERIMENT 2: DELETION         ");
        System.out.println("======================================");
        dll.removeFirst();
        dll.print();
        
        dll.removeLast();
        dll.print();
        
        dll.remove(1);
        dll.print();

        System.out.println("======================================");
        System.out.println("       ASSIGNMENT 12.5 TESTING        ");
        System.out.println("======================================");
        
        // 1. Test getSize()
        System.out.println("Current Size of DLL: " + dll.getSize());
        
        // 2. Test getFirst(), getLast(), getIndex()
        System.out.println("First Node: " + (dll.getFirst() != null ? dll.getFirst().name : "Empty"));
        System.out.println("Last Node: " + (dll.getLast() != null ? dll.getLast().name : "Empty"));
        System.out.println("Node at index 1: " + (dll.getIndex(1) != null ? dll.getIndex(1).name : "Empty"));
        
        // 3. Test indexOf()
        System.out.println("Index of Prabowo (NIM 112): " + dll.indexOf("112"));
        System.out.println("Index of Anton (NIM 111): " + dll.indexOf("111"));
        
        // 4. Test add(data, index)
        System.out.println("\n---> Adding a new student at Index 1...");
        dll.add(new Student("999", "Newbie", "TI-1I", 4.0), 1);
        dll.print();
        
        // 5. Test removeAfter()
        System.out.println("---> Removing the node after Anton (NIM 111)...");
        dll.removeAfter("111");
        dll.print();
    }
}
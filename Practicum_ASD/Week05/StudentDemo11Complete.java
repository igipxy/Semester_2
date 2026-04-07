public class StudentDemo11Complete {
    public static void main(String[] args) {
        // Test Bubble Sort
        TopStudents11 ts1 = new TopStudents11();
        ts1.add(new Student11("123", "Alice", "A", 3.5));
        ts1.add(new Student11("124", "Bob", "B", 3.8));
        ts1.add(new Student11("125", "Charlie", "A", 3.2));
        ts1.add(new Student11("126", "David", "C", 3.9));
        ts1.add(new Student11("127", "Eve", "B", 3.6));
        
        System.out.println("=== Bubble Sort (Descending) ===");
        ts1.bubbleSort();
        ts1.print();
        
        // Test Selection Sort
        TopStudents11 ts2 = new TopStudents11();
        ts2.add(new Student11("123", "Alice", "A", 3.5));
        ts2.add(new Student11("124", "Bob", "B", 3.8));
        ts2.add(new Student11("125", "Charlie", "A", 3.2));
        ts2.add(new Student11("126", "David", "C", 3.9));
        ts2.add(new Student11("127", "Eve", "B", 3.6));
        
        System.out.println("\n=== Selection Sort (Ascending) ===");
        ts2.selectionSort();
        ts2.print();
        
        // Test Insertion Sort
        TopStudents11 ts3 = new TopStudents11();
        ts3.add(new Student11("123", "Alice", "A", 3.5));
        ts3.add(new Student11("124", "Bob", "B", 3.8));
        ts3.add(new Student11("125", "Charlie", "A", 3.2));
        ts3.add(new Student11("126", "David", "C", 3.9));
        ts3.add(new Student11("127", "Eve", "B", 3.6));
        
        System.out.println("\n=== Insertion Sort (Ascending) ===");
        ts3.insertionSort();
        ts3.print();
        
        // Test Insertion Sort Descending
        TopStudents11 ts4 = new TopStudents11();
        ts4.add(new Student11("123", "Alice", "A", 3.5));
        ts4.add(new Student11("124", "Bob", "B", 3.8));
        ts4.add(new Student11("125", "Charlie", "A", 3.2));
        ts4.add(new Student11("126", "David", "C", 3.9));
        ts4.add(new Student11("127", "Eve", "B", 3.6));
        
        System.out.println("\n=== Insertion Sort (Descending) ===");
        ts4.insertionSortDescending();
        ts4.print();
    }
}
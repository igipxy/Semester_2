public class SLLMain11 {
    public static void main(String[] args) {
    SingleLinkedList11 sll = new SingleLinkedList11();

    Student11 std1 = new Student11("001", "Student 1", "TI-1I", 3.89);
    Student11 std2 = new Student11("002", "Student 2", "TI-1I", 3.45);
    Student11 std3 = new Student11("003", "Student 3", "TI-1I", 3.20);
    Student11 std4 = new Student11("004", "Student 4", "TI-1I", 3.00);

    sll.print();
    sll.addFirst(std4);
    sll.print();
    sll.addLast(std1);
    sll.print();
    sll.insertAfter(std3, "Student 4");
    sll.insertAt(2, std2);
    sll.print();

    System.out.println("Data at index 1 is:");
    Student11 data = sll.getData(1);
    data.print();
    int idx = sll.indexOf("Student 1");
    System.out.println("Student 1 is located at index: " + idx);
    sll.removeFirst();
    sll.removeLast();
    sll.print();
    sll.removeAt(0);
    sll.print();
}
}
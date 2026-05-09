public class SLLMain11 {
    public static void main(String[] args) {
        SingleLinkedList11 sll = new SingleLinkedList11();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter NIM: ");
        String nim = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Class: ");
        String kls = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine(); // consume newline
        Student11 std = new Student11(nim, name, kls, gpa);
        sll.addLast(std); // or any method you want

        sll.print();
        sll.addFirst(std4);
        sll.print();
        sll.addLast(std1);
        sll.print();
        sll.insertAfter(std3, "Student 4");
        sll.insertAt(2, std2);
        sll.print();
    }
}
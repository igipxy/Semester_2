import java.util.Scanner;

public class QueueMain11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLinkedList11 queue = new QueueLinkedList11();

        int choice;
        do {
            System.out.println("\n=== Student Service Queue ===");
            System.out.println("1. Register (Enqueue)");
            System.out.println("2. Call Next Student (Dequeue)");
            System.out.println("3. Check Front Student");
            System.out.println("4. Check Rear Student");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Clear Queue");
            System.out.println("8. Display Total Students");
            System.out.println("9. Display Queue");
            System.out.println("0. Exit");
            System.out.print("Choose menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Class: ");
                    String kls = sc.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();
                    Student11 std = new Student11(nim, name, kls, gpa);
                    queue.enqueue(std);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peekFront();
                    break;
                case 4:
                    queue.peekRear();
                    break;
                case 5:
                    System.out.println("Queue is empty: " + queue.isEmpty());
                    break;
                case 6:
                    System.out.println("Queue is full: " + queue.isFull());
                    break;
                case 7:
                    queue.clear();
                    break;
                case 8:
                    queue.displayTotal();
                    break;
                case 9:
                    queue.printQueue();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
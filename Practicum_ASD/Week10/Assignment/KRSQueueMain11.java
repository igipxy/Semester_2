import java.util.Scanner;

public class KRSQueueMain11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KRSQueue11 queue = new KRSQueue11(10); // Max queue size = 10
        final int MAX_DPA = 30; // Max students per DPA
        int choice;

        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║     KRS APPROVAL QUEUE SYSTEM        ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Add Student to Queue (Enqueue)   ║");
            System.out.println("║  2. Process KRS Approval (2 at once) ║");
            System.out.println("║  3. Show First Student               ║");
            System.out.println("║  4. Show First Two Students            ║");
            System.out.println("║  5. Show Last Student                ║");
            System.out.println("║  6. Show All Students in Queue       ║");
            System.out.println("║  7. Show Queue Statistics            ║");
            System.out.println("║  8. Clear Queue                      ║");
            System.out.println("║  0. Exit                             ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Choose menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Check DPA limit (total students cannot exceed 30)
                    if (queue.getTotalStudents() >= MAX_DPA) {
                        System.out.println("DPA capacity reached! Maximum 30 students.");
                        break;
                    }
                    
                    System.out.print("NIM           : ");
                    String nim = sc.nextLine();
                    System.out.print("Name          : ");
                    String name = sc.nextLine();
                    System.out.print("Study Program : ");
                    String studyProgram = sc.nextLine();
                    System.out.print("Class         : ");
                    String className = sc.nextLine();
                    
                    KRSStudent11 student = new KRSStudent11(nim, name, studyProgram, className);
                    queue.enqueue(student);
                    break;

                case 2:
                    queue.processApproval();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.peekFirstTwo();
                    break;

                case 5:
                    queue.peekLast();
                    break;

                case 6:
                    queue.print();
                    break;

                case 7:
                    System.out.println("\n--- Queue Statistics ---");
                    System.out.println("Students in queue       : " + queue.getQueueSize());
                    System.out.println("Students approved       : " + queue.getTotalApproved());
                    System.out.println("Students not approved   : " + queue.getRemaining());
                    System.out.println("Total students (DPA)    : " + queue.getTotalStudents() + " / " + MAX_DPA);
                    System.out.println("------------------------\n");
                    break;

                case 8:
                    queue.clear();
                    break;

                case 0:
                    System.out.println("Thank you for using KRS Approval System!");
                    break;

                default:
                    System.out.println("Invalid menu choice!");
            }
        } while (choice != 0);
    }
}
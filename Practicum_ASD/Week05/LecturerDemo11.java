import java.util.Scanner;

public class LecturerDemo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LecturerData11 lecturerData = new LecturerData11();
        int choice;
        
        do {
            System.out.println("\n===== LECTURER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Data");
            System.out.println("2. Display Data");
            System.out.println("3. Sort ASC (Youngest to Oldest - Bubble Sort)");
            System.out.println("4. Sort DSC (Oldest to Youngest - Selection Sort)");
            System.out.println("5. Exit");
            System.out.print("Choose menu: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Gender (true=Male, false=Female): ");
                    boolean gender = sc.nextBoolean();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    
                    Lecturer11 dsn = new Lecturer11(id, name, gender, age);
                    lecturerData.add(dsn);
                    break;
                case 2:
                    lecturerData.print();
                    break;
                case 3:
                    lecturerData.sortingASC();
                    lecturerData.print();
                    break;
                case 4:
                    lecturerData.sortingDSC();
                    lecturerData.print();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        
        sc.close();
    }
}
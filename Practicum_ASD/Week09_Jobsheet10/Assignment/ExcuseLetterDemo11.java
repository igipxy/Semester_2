import java.util.Scanner;

public class ExcuseLetterDemo11 {
    public static void main(String[] args) {
        ExcuseLetterStack11 stack = new ExcuseLetterStack11(10);
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Submit Excuse Letter");
            System.out.println("2. Process Excuse Letter");
            System.out.println("3. View Latest Excuse Letter");
            System.out.println("4. Search for Letter");
            System.out.print("Choose a menu: ");
            choice = scan.nextInt();
            scan.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = scan.nextLine();
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.print("Class Name: ");
                    String className = scan.nextLine();
                    System.out.print("Type of Excuse (S: Sick, I: Other): ");
                    char type = scan.nextLine().charAt(0);
                    System.out.print("Duration (days): ");
                    int duration = scan.nextInt();

                    ExcuseLetter11 letter = new ExcuseLetter11(id, name, className, type, duration);
                    stack.push(letter);
                    System.out.println(name + "'s excuse letter has been successfully submitted!!");
                    break;

                case 2:
                    ExcuseLetter11 processed = stack.pop();
                    if (processed != null) {
                        System.out.println("Processing excuse letter from " + processed.name);
                        System.out.println("Type: " + processed.typeOfExcuse);
                        System.out.println("Duration: " + processed.duration + " days");
                        System.out.println("Letter has been processed!");
                    }
                    break;

                case 3:
                    ExcuseLetter11 latest = stack.peek();
                    if (latest != null) {
                        System.out.println("Latest excuse letter from: " + latest.name);
                        System.out.println("Duration: " + latest.duration + " days");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name to search: ");
                    String searchName = scan.nextLine();
                    stack.search(searchName);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice >= 1 && choice <= 4);
    }
}
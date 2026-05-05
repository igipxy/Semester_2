import java.util.Scanner;

public class StudentDemo11 {
    public static void main(String[] args) {
        // Create stack with capacity of 5 assignments
        StudentAssignmentStack11 stack = new StudentAssignmentStack11(5);
        
        Scanner scan = new Scanner(System.in);
        int choice;
        
        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Submit Assignment");
            System.out.println("2. Grade Assignment");
            System.out.println("3. View Top Assignment");
            System.out.println("4. View All Assignments");
            System.out.print("Choose a menu: ");
            choice = scan.nextInt();
            scan.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:  // SUBMIT - Push operation
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Class Name: ");
                    String className = scan.nextLine();
                    
                    Student11 std = new Student11(nim, name, className);
                    stack.push(std);
                    System.out.println(name + "'s assignment has been successfully submitted!!");
                    break;
                    
                case 2:
                    Student11 graded = stack.pop();
                    if (graded != null) {
                        System.out.println("Grading assignment from " + graded.name);
                        System.out.print("Input grade (0-100): ");
                        int grade = scan.nextInt();
                        graded.grading(grade);
                        System.out.printf("Assignment grade of %s is %d\n", graded.name, grade);
        
                        // NEW: Convert to binary
                        String binary = stack.convertToBinary(grade);
                        System.out.printf("Assignment grade in binary is %s\n", binary);
                    }
                    break;
                    
                case 3:  // VIEW TOP - Peek operation
                    Student11 topStudent = stack.peek();
                    if (topStudent != null) {
                        System.out.println("The last assignment comes from " + topStudent.name);
                    }
                    break;
                    
                case 4:  // VIEW ALL - Print operation
                    stack.print();
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice >= 1 && choice <= 4);  // Loop until invalid choice
    }
}
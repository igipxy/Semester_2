import java.util.Scanner;

public class MainStudent11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner sl = new Scanner(System.in);

        // Asking user for the number of students 
        System.out.print("How many students do you want to input? ");
        int amountStudent = s.nextInt();

        SearchStudent11 data = new SearchStudent11(amountStudent);

        System.out.println("------------------------------------");
        System.out.println("Input student data accordingly from smallest NIM");

        for (int i = 0; i < amountStudent; i++) {
            System.out.println("------------------------------------");
            System.out.print("NIM\t: ");
            int nim = s.nextInt();
            System.out.print("Name\t: ");
            String name = sl.nextLine();
            System.out.print("Age\t: ");
            int age = s.nextInt();
            System.out.print("GPA\t: ");
            double gpa = s.nextDouble();

            Students11 std = new Students11(nim, age, name, gpa);
            data.add(std);
        }

        System.out.println("------------------------------------");
        System.out.println("Entire Student Data:");
        data.display();

        System.out.println("____________________________________");
        System.out.println("____________________________________");
        System.out.print("Search student by NIM: ");
        int search = s.nextInt();

        // Testing Sequential Search [cite: 34, 35, 36, 37, 38]
        System.out.println("====================================");
        System.out.println("Using Sequential Search");
        int positionSeq = data.findSeqSearch(search);
        data.showPosition(search, positionSeq);
        data.showData(search, positionSeq);

        // Testing Binary Search [cite: 52, 53]
        System.out.println("====================================");
        System.out.println("Using Binary Search");
        int positionBin = data.findBinarySearch(search, 0, amountStudent - 1);
        data.showPosition(search, positionBin);
        data.showData(search, positionBin);
        
        s.close();
        sl.close();
    }
}
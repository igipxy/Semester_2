import java.util.Scanner;

public class Main11 {
    static Student11[] students = new Student11[10];
    static Book11[] books = new Book11[10];
    static Borrowing11[] borrowings = new Borrowing11[20];
    
    static int studentCount = 0;
    static int bookCount = 0;
    static int borrowingCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initDummyData();

        int choice = 0;
        do {
            System.out.println("\n=== LIBRARY READING ROOM SYSTEM ===");
            System.out.println("1. Display Students");
            System.out.println("2. Display Books");
            System.out.println("3. Display Borrowings (Original Order)");
            System.out.println("4. Sort by Fine (Merge Sort - Descending)");
            System.out.println("5. Search by NIM (Binary Search)");
            System.out.println("6. Exit");
            System.out.print("Choose menu (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    displayAllBorrowings();
                    break;
                case 4:
                    // Create a copy so we don't mess up original data permanently if we don't want to
                    Borrowing11[] sortedByFine = cloneBorrowingArray();
                    mergeSortByFine(sortedByFine, 0, borrowingCount - 1);
                    System.out.println("\n--- Borrowing Records (Sorted by Highest Fine) ---");
                    printBorrowingArray(sortedByFine);
                    break;
                case 5:
                    System.out.print("Enter Student NIM to search: ");
                    String targetNim = scanner.nextLine();
                    searchBorrowingByNim(targetNim);
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // ================= DATA DISPLAY =================
    
    static void displayAllStudents() {
        System.out.println("\n--- Master Students ---");
        System.out.printf("| %-12s | %-20s | %-15s |\n", "NIM", "Name", "Major");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }

    static void displayAllBooks() {
        System.out.println("\n--- Master Books ---");
        System.out.printf("| %-10s | %-25s | %-6s |\n", "Code", "Title", "Year");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
        }
    }

    static void displayAllBorrowings() {
        System.out.println("\n--- All Borrowing Records ---");
        printBorrowingArray(borrowings);
    }

    static void printBorrowingArray(Borrowing11[] arr) {
        System.out.printf("| %-12s | %-15s | %-10s | %-10s | %-12s |\n", "NIM", "Student Name", "Book Code", "Duration", "Fine");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < borrowingCount; i++) {
            arr[i].displayBorrowing();
        }
    }

    // ================= ALGORITHMS =================

    // 1. Merge Sort based on FINE (Descending)
    static void mergeSortByFine(Borrowing11[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortByFine(arr, left, mid);
            mergeSortByFine(arr, mid + 1, right);
            mergeFine(arr, left, mid, right);
        }
    }

    static void mergeFine(Borrowing11[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Borrowing11[] leftArr = new Borrowing11[n1];
        Borrowing11[] rightArr = new Borrowing11[n2];

        for (int i = 0; i < n1; ++i) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Descending order (largest fine first)
            if (leftArr[i].getFine() >= rightArr[j].getFine()) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // 2. Merge Sort based on NIM (Ascending) - Prerequisite for Binary Search
    static void mergeSortByNim(Borrowing11[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortByNim(arr, left, mid);
            mergeSortByNim(arr, mid + 1, right);
            mergeNim(arr, left, mid, right);
        }
    }

    static void mergeNim(Borrowing11[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Borrowing11[] leftArr = new Borrowing11[n1];
        Borrowing11[] rightArr = new Borrowing11[n2];

        for (int i = 0; i < n1; ++i) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // Ascending order string comparison
            if (leftArr[i].getStudent().getNim().compareToIgnoreCase(rightArr[j].getStudent().getNim()) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // 3. Binary Search based on NIM
    static void searchBorrowingByNim(String nim) {
        // Condition: Data must be sorted by NIM first
        Borrowing11[] sortedByNim = cloneBorrowingArray();
        mergeSortByNim(sortedByNim, 0, borrowingCount - 1);

        int left = 0;
        int right = borrowingCount - 1;
        int foundIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = sortedByNim[mid].getStudent().getNim().compareToIgnoreCase(nim);

            if (compareResult == 0) {
                foundIndex = mid;
                break;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (foundIndex == -1) {
            System.out.println("No borrowing record found for NIM: " + nim);
        } else {
            System.out.println("\n--- Borrowing Records for NIM: " + nim + " ---");
            System.out.printf("| %-12s | %-15s | %-10s | %-10s | %-12s |\n", "NIM", "Student Name", "Book Code", "Duration", "Fine");
            System.out.println("-------------------------------------------------------------------------");
            
            // Since a student might borrow multiple books, we scan backwards and forwards from foundIndex
            // to print all records belonging to this NIM.
            int start = foundIndex;
            while (start > 0 && sortedByNim[start - 1].getStudent().getNim().equalsIgnoreCase(nim)) {
                start--;
            }
            int end = foundIndex;
            while (end < borrowingCount - 1 && sortedByNim[end + 1].getStudent().getNim().equalsIgnoreCase(nim)) {
                end++;
            }

            for (int i = start; i <= end; i++) {
                sortedByNim[i].displayBorrowing();
            }
        }
    }

    // ================= UTILITIES =================

    static Borrowing11[] cloneBorrowingArray() {
        Borrowing11[] clone = new Borrowing11[borrowingCount];
        for (int i = 0; i < borrowingCount; i++) {
            clone[i] = borrowings[i];
        }
        return clone;
    }

    static void initDummyData() {
        // Add Students
        students[studentCount++] = new Student11("220011", "Alice", "Informatics");
        students[studentCount++] = new Student11("220022", "Bob", "Information Sys");
        students[studentCount++] = new Student11("220033", "Charlie", "Data Science");

        // Add Books
        books[bookCount++] = new Book11("B001", "Java Programming", 2021);
        books[bookCount++] = new Book11("B002", "Data Structures", 2020);
        books[bookCount++] = new Book11("B003", "Machine Learning", 2022);

        // Add Borrowing Records (Mix of short and long durations to test fines)
        borrowings[borrowingCount++] = new Borrowing11(students[0], books[0], 3); // 3 days, no fine
        borrowings[borrowingCount++] = new Borrowing11(students[1], books[1], 7); // 7 days, 2 days fine (10,000)
        borrowings[borrowingCount++] = new Borrowing11(students[2], books[2], 10); // 10 days, 5 days fine (25,000)
        borrowings[borrowingCount++] = new Borrowing11(students[1], books[0], 6); // 6 days, 1 day fine (5,000)
        borrowings[borrowingCount++] = new Borrowing11(students[0], books[2], 2); // 2 days, no fine
    }
}
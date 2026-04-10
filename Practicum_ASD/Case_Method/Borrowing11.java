public class Borrowing11 {
    private Student11 student;
    private Book11 book;
    private int borrowDays;
    private double fine;

    public Borrowing11(Student11 student, Book11 book, int borrowDays) {
        this.student = student;
        this.book = book;
        this.borrowDays = borrowDays;
        calculateFine();
    }

    // Automatically calculate fine if duration > 5 days
    private void calculateFine() {
        if (this.borrowDays > 5) {
            int extraDays = this.borrowDays - 5;
            this.fine = extraDays * 5000.0; // Assume fine is 5000 per day late
        } else {
            this.fine = 0.0;
        }
    }

    public Student11 getStudent() {
        return student;
    }

    public Book11 getBook() {
        return book;
    }

    public double getFine() {
        return fine;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public void displayBorrowing() {
        System.out.printf("| %-12s | %-15s | %-10s | %-10d | Rp %-9.0f |\n", 
            student.getNim(), student.getName(), book.getCode(), borrowDays, fine);
    }
}
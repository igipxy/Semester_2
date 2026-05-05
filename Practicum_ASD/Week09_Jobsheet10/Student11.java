public class Student11 {
    // Attributes (from class diagram)
    String nim;        // Student ID number
    String name;       // Student name
    String className;  // Class name (example "1I")
    int grade;         // Assignment grade (-1 = not graded yet)

    // Default constructor
    public Student11() {
    }

    // Parameterized constructor
    public Student11(String nim, String name, String className) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.grade = -1;  // Default: not graded
    }

    // Method to set the grade when assignment is graded
    void grading(int grade) {
        this.grade = grade;
    }
}
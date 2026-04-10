public class Students11 {
    int nim, age;
    String name;
    double gpa;

    // Constructor to initialize the object [cite: 21]
    public Students11(int nim, int age, String name, double gpa) {
        this.nim = nim;
        this.age = age;
        this.name = name;
        this.gpa = gpa;
    }

    // Method to display individual student data [cite: 22]
    public void display() {
        System.out.println("NIM = " + nim);
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println("GPA = " + gpa);
    }
}
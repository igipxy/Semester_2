public class Student11 {
    String nim;
    String name;
    String studentClass;
    double gpa;
    
    public Student11() {
    }
    
    public Student11(String nim, String name, String studentClass, double gpa) {
        this.nim = nim;
        this.name = name;
        this.studentClass = studentClass;
        this.gpa = gpa;
    }
    
    public void print() {
        System.out.println("NIM: " + nim);
        System.out.println("Name: " + name);
        System.out.println("Class: " + studentClass);
        System.out.println("GPA: " + gpa);
        System.out.println("---------------------------");
    }
}
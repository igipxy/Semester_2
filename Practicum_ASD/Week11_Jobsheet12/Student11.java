public class Student11 {
    String nim, name, className;
    double gpa;

    public Student11() {
    }

    public Student11(String nm, String nama, String kls, double ip) {
        nim = nm;
        name = nama;
        className = kls;
        gpa = ip;
    }

    void print() {
        System.out.println(nim + " - " + name + " - " + className + " - " + gpa);
    }
}
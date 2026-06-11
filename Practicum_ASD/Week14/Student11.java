package Practicum_ASD.Week14;

public class Student11 {
    String nim, name, className;
    double ipk;

    public Student11() {
    }

    public Student11(String nm, String nama, String kls, double ip) {
        nim = nm;
        name = nama;
        className = kls;
        ipk = ip;
    }

    void print() {
        System.out.println(nim + " - " + name + " - " + className + " - " + ipk);
    }
}

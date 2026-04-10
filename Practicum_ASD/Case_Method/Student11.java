public class Student11 {
    private String nim;
    private String name;
    private String major;

    public Student11(String nim, String name, String major) {
        this.nim = nim;
        this.name = name;
        this.major = major;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public void displayStudent() {
        System.out.printf("| %-12s | %-20s | %-15s |\n", nim, name, major);
    }
}
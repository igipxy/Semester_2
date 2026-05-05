public class Student11 {
    // Attributes
    String nim;
    String name;
    String studyProgram;
    String className;

    // Parameterized constructor
    public Student11(String nim, String name, String studyProgram, String className) {
        this.nim = nim;
        this.name = name;
        this.studyProgram = studyProgram;
        this.className = className;
    }

    // Display student data
    void print() {
        System.out.println(nim + " - " + name + " - " + studyProgram + " - " + className);
    }
}
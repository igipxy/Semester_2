public class ExcuseLetter11 {
    String id;
    String name;
    String className;
    char typeOfExcuse;  // 'S' = Sick, 'I' = Other
    int duration;       // Length of leave in days

    public ExcuseLetter11() {
    }

    public ExcuseLetter11(String id, String name, String className, char type, int duration) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.typeOfExcuse = type;
        this.duration = duration;
    }
}
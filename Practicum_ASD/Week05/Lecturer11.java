public class Lecturer11 {
    String id;
    String name;
    boolean gender;
    int age;
    
    public Lecturer11(String id, String name, boolean gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public void print() {
        String genderStr = gender ? "Male" : "Female";
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + genderStr);
        System.out.println("Age: " + age);
        System.out.println("---------------------------");
    }
}
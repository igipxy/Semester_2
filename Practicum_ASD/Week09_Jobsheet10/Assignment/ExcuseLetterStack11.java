public class ExcuseLetterStack11 {
    ExcuseLetter11[] stack;
    int size;
    int top;

    public ExcuseLetterStack11(int size) {
        this.size = size;
        top = -1;
        stack = new ExcuseLetter11[size];
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(ExcuseLetter11 letter) {
        if (!isFull()) {
            top++;
            stack[top] = letter;
        } else {
            System.out.println("Stack is already full!!");
        }
    }

    ExcuseLetter11 pop() {
        if (!isEmpty()) {
            ExcuseLetter11 letter = stack[top];
            top--;
            return letter;
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    ExcuseLetter11 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    void print() {
        System.out.println("Excuse Letter list:");
        System.out.println("ID\tName\tClass\tType\tDuration");
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i].id + "\t" + stack[i].name + "\t" + 
                stack[i].className + "\t" + stack[i].typeOfExcuse + "\t" + stack[i].duration);
        }
        System.out.println("");
    }

    // Search for letter by student name
    void search(String searchName) {
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (stack[i].name.equalsIgnoreCase(searchName)) {
                System.out.println("Letter found!");
                System.out.println("ID: " + stack[i].id);
                System.out.println("Name: " + stack[i].name);
                System.out.println("Class: " + stack[i].className);
                System.out.println("Type: " + stack[i].typeOfExcuse);
                System.out.println("Duration: " + stack[i].duration + " days");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Letter from " + searchName + " not found.");
        }
    }
}
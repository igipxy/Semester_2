public class StudentAssignmentStack11 {
    // Attributes
    Student11[] stack;  // Array to store Student objects
    int size;           // Maximum capacity of stack
    int top;            // Index of top element (-1 = empty)

    // Constructor
    public StudentAssignmentStack11(int size) {
        this.size = size;
        this.top = -1;              // Stack starts empty
        this.stack = new Student11[size];  // Create array
    }

    // Check if stack is full
    boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    // Check if stack is empty
    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // Add student assignment to stack (PUSH operation)
    void push(Student11 std) {
        if (!isFull()) {           // Only push if there's space
            top++;                 // Move top pointer up
            stack[top] = std;      // Place student at top
        } else {
            System.out.println("Stack is already full!!");
        }
    }

    // Remove and return top assignment (POP operation)
    Student11 pop() {
        if (!isEmpty()) {          // Only pop if stack has data
            Student11 std = stack[top];  // Get top student
            top--;                      // Move top pointer down
            return std;                 // Return the student
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    // View top assignment without removing (PEEK operation)
    Student11 peek() {
        if (!isEmpty()) {
            return stack[top];     // Return top student
        } else {
            System.out.println("There is no data in Stack!!");
            return null;
        }
    }

    // Display all assignments in stack
    void print() {
        System.out.println("Assignment list:");
        System.out.println("NIM\tName\tClass Name");
        for (int i = 0; i <= top; i++) {  // Loop from bottom to top
            System.out.println(stack[i].nim + "\t" 
                             + stack[i].name + "\t" 
                             + stack[i].className);
        }
        System.out.println("");
    }

   
    String convertToBinary(int grade) {
        ConversionStack11 stack = new ConversionStack11();
    
    // Step 1: Convert decimal to binary and push remainders
        while (grade > 0) {
            int mod = grade % 2;    // Get remainder (0 or 1)
            stack.push(mod);        // Push remainder to stack
            grade = grade / 2;      // Divide by 2
    }
    
    // Step 2: Pop all to get binary in correct order
        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop();  // Pop and append to string
    }
    
    return binary;
    }
}
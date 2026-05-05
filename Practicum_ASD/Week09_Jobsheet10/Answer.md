Here is your text cleanly formatted in Markdown:

### Question 1: Why Stack?
**Answer:** A Stack follows LIFO (Last-In, First-Out) — the last assignment submitted is graded first (top of the stack). This matches real-world behavior where the lecturer picks up the top paper first. A Queue (FIFO) would grade the oldest first, which doesn't match the scenario.

---

### Question 2: `push()` vs `pop()`

| Feature | `push()` | `pop()` |
| :--- | :--- | :--- |
| **Action** | Add to top | Remove from top |
| **Parameters** | Takes `Student` object | No parameters |
| **Return** | `void` | Returns `Student` object |
| **In program** | Submit assignment | Grade assignment |

---

### Question 3: Why check `!isFull()` before push?
**Answer:** Without this check, if the stack is full, `top++` would exceed array bounds, causing an `ArrayIndexOutOfBoundsException` — resulting in a program crash!

---

### Question 4: Stack capacity
**Answer:** 5 assignments. This is determined by the following initialization:

```java
StudentAssignmentStack11 stack = new StudentAssignmentStack11(5);
```
The `size` variable in the constructor sets this limit.

---

### Question 5: Show first submitted student

**In `StudentAssignmentStack11`:**
```java
Student11 getFirst() {
    if (!isEmpty()) {
        return stack[0]; // Bottom of stack = first submitted
    } else {
        System.out.println("Stack is empty!");
        return null;
    }
}
```

**In `StudentDemo11`:** (Add to your switch/menu block)
```java
case 5:
    Student11 first = stack.getFirst();
    if (first != null) {
        System.out.println("First assignment submitted by: " + first.name);
    }
    break;
```

---

### Question 6: Count assignments

**In `StudentAssignmentStack11`:**
```java
int count() {
    return top + 1; // top is index, so +1 gives count
}
```
**Explanation:** Because `top = -1` when the stack is empty (0 items), `top = 0` when there is 1 item, and so on.

---

### Question 7: Reflection

**Real-world applications of Stacks:**
*   **Browser back button:** The last visited page is the first one you return to.
*   **Undo/Redo in editors:** The most recent action is the first one to be undone.
*   **Function call stack:** Used extensively by compilers in programming.
*   **Expression evaluation:** Used in calculators and parsing algorithms.
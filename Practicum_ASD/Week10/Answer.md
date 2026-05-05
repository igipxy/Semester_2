
---

## 🟢 Experiment 1: Circular Queue Basics

### Q1: Why initialize `front = rear = -1` and `size = 0`?
*   **Indices:** `front = -1` and `rear = -1` indicate the queue is currently empty with no valid data positions.
*   **Tracking:** `size = 0` explicitly tracks the number of elements, making it easier to write `isEmpty()` and `isFull()` methods.
*   **First Addition:** When the first element is added, both pointers move to `0` (the first valid array index).

### Q2 & Q3: Circular Logic using Modulo (`%`)
In a circular queue, we use the formula `(index + 1) % max` to move pointers.

*   **Rear (Enqueue):** This adds 1 to the `rear`, but wraps it back to `0` if it reaches the end of the array.
    *   *Example:* If `rear = 3` and `max = 4`, then $(3+1) \pmod 4 = 0$.
*   **Front (Dequeue):** Moves the `front` forward. The "removed" data isn't deleted immediately; it is simply ignored by the pointer and overwritten later.



### Q4 & Q5: Printing a Circular Queue
We cannot simply start a loop at `0` because the queue is circular—the "start" of the queue might be in the middle of the array.
*   **Start Point:** `int i = front` ensures we begin at the oldest element (FIFO order).
*   **Loop Increment:** `i = (i + 1) % max` allows the loop to "jump" from the last index back to the start of the array to find the remaining elements.

### Q6 & Q7: Handling Overflow
To prevent errors when the queue is full, we use overflow checks:

```java
if (isFull()) {
    System.out.println("Queue is full!!!");
    System.exit(1); // Optional: Force stops the program
}
```

---

## 🔵 Experiment 2: Queue of Objects (Students)

### Q1: Data Type Differences

| Feature | Experiment 1 (Queue) | Experiment 2 (StudentQueue) |
| :--- | :--- | :--- |
| **Data Type** | `int[]` | `Student11[]` |
| **Storage** | Primitive integers | Object references (NIM, Name, etc.) |

> **Note:** Managing objects is more representative of real-world apps where each entry contains multiple attributes rather than a single number.

### Q2: Implementation Differences

**Enqueue Comparison:**
| Aspect | `Queue.enqueue` | `StudentQueue.enqueue` |
| :--- | :--- | :--- |
| **Parameter** | `int dt` | `Student11 dt` |
| **Wrap-around** | `(rear + 1) % max` | Complex `if-else` logic |
| **Full Check** | `!isFull()` then add | `isFull()` then return |

**Dequeue Comparison:**
| Aspect | `Queue.dequeue` | `StudentQueue.dequeue` |
| :--- | :--- | :--- |
| **Return Type** | `int` | `Student11` |
| **Empty Return** | `0` | `null` |

### Q3: Why `front = 0` in StudentQueue?
In Experiment 2, setting `front = 0` is a design choice that simplifies the implementation. While Experiment 1 uses `-1` to represent a "null" state, Experiment 2 assumes the first element will always land at index `0`, making the circular logic slightly more straightforward.

### Q4: Adding `viewRear()` Functionality

**1. In `StudentQueue11.java`:**
```java
void viewRear() {
    if (!isEmpty()) {
        System.out.println("Rear data: ");
        data[rear].print();
    } else {
        System.out.println("Queue is empty!!!");
    }
}
```

**2. In `StudentQueueMain11.java`:**
Add this to your menu options:
```java
case 6:
    queue.viewRear();
    break;
```
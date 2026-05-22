## Core Concepts

* **Singly vs. Doubly Linked List:** A Singly Linked List only has one pointer (next) navigating forward. A Doubly Linked List contains two pointers (prev and next), allowing traversal in both forward and backward directions.
* **Purpose of Pointers:**
* next: Points to the succeeding node in the list.
* prev: Points back to the preceding node.


* **Constructor:** The DoubleLinkedLists() constructor initializes an empty list by setting both the head and tail pointers to null.

---

## Pointer Logic & Node Connections

* head = tail = newNode
If the list is completely empty, the newly added node becomes both the very first element (head) and the very last element (tail) simultaneously.
* head.prev = newNode
When inserting a new node at the front, this statement links the existing head node backward to the new node. This ensures the doubly linked structure remains intact before moving the head pointer.
* temp.next.prev = newNode
During a middle insertion, temp.next targets the node directly after the current one. The .prev attribute targets its backward pointer, successfully linking the downstream node backward to the newly inserted node.

---

## Traversal & Edge Cases

* **Traversal Implementation:** Traversal is implemented using loops in both the insertAfter() and print() methods.
* temp = temp.next
Updates the temp variable to point to the next node in the sequence, allowing the loop to iterate smoothly through the list.
* if (temp == tail) { addLast(data); }
Catches edge cases where the insertion point happens to be exactly at the end of the list. **This must be implemented.** If removed, attempting to access temp.next.prev would throw a NullPointerException because temp.next is null at the tail.

---

## Searching & Bug Fixes

* **Robust Matching:** equalsIgnoreCase(key) compares the nim stored in the current node with the search key while ignoring capitalization.
* **Insertion Warning Bug:**
* *The Issue:* The loop while (temp != null) continues running to the end of the list even after data is successfully inserted. Once the loop ends, temp inevitably evaluates to null, triggering an error message.
* *The Fix:* This is corrected in the DoubleLinkedLists.java code by adding a return; statement immediately after a successful insertion to break out of the method.
Experiment 1 Questions & Answers

1. Why does compiling result in "Linked List is Empty" on the first line?
Because sll.print() is called before any student is inserted. At that moment, head is still null, so isEmpty() returns true.

2. Explain the general purpose of variable temp in each method!
temp is a temporary reference variable used to traverse the linked list. It starts at head and moves from node to node (temp = temp.next) so we can search, insert, or delete without losing the original head reference.

3. Modify the code so data can be added via keyboard input!

4. What would happen if we did not use the tail attribute?
addLast() would need to traverse from head every time to find the last node, making it O(n) instead of O(1). The code would still work functionally but would be slower for large lists.

Experiment 2 Questions & Answers

1. Why is the break keyword used in the remove function?
To stop the loop immediately after the target node is found and removed. Without break, the loop would continue traversing, potentially causing a NullPointerException or deleting the wrong node.

2. Explain the purpose of this code in the remove method:
java

temp.next = temp.next.next;
if (temp.next == null) {
    tail = temp;
}

temp.next = temp.next.next; → Skips the node to be deleted by linking the current node directly to the node after the next one.

if (temp.next == null) { tail = temp; } → If the deleted node was the last node, temp becomes the new last node, so tail must be updated to point to temp.
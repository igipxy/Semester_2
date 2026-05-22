## Deletion Logic & Node Detachment

* head = head.next; head.prev = null;
This shifts the head pointer one spot forward to the second node and severs its backward connection to the old first node. This completely detaches the old node so it can be cleared by garbage collection.
* **Middle Removal Link Updates:**
* temp.prev.next = temp.next; bypasses temp moving forward.
* temp.next.prev = temp.prev; bypasses temp moving backward.
* Together, these ensure the target node is effectively isolated and deleted from the chain.



---

## Edge Cases & Validation

* **Purpose of** if (isEmpty())**:**
This prevents NullPointerExceptions by ensuring the method doesn't attempt to delete data from a list that is already empty.
* **Why check** if (head == tail)**:**
If there is only one element left in the list, both head and tail point to the same node. Executing standard deletion logic here would break the list. Setting both to null properly resets the list to an empty state.
* **Handling** index == 0 **and** temp == tail:
Removing at index 0 routes directly to removeFirst(), while removing at the end routes to removeLast(). This DRY (Don't Repeat Yourself) approach reuses edge-case logic that already properly manages the main head and tail pointers.
* **Adding Boundaries Check:**
* *The Fix:* This is implemented in the remove(int index) code by using an if (index < 0 || index >= getSize()) check at the start of the method to immediately catch invalid inputs.



---

## Efficiency & Architecture

* **Without a** tail **Attribute:**
Without a tail reference, removing the last element would require an $O(N)$ traversal starting from head all the way to the end (while (temp.next != null)) just to find the last node and its preceding node. This drastically reduces the efficiency of tail operations.
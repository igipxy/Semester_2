# Experiment 1 - Q&A

**1. Why is data search in a binary search tree more efficient compared to a regular binary tree?**
It eliminates half the remaining tree at each step (O(log n) time) because left children are smaller and right children are larger.

**2. What are the purposes of the left and right attributes in the Node class?**
They link parent nodes to their child nodes to create the tree structure.

**3a. What is the function of the root attribute in the BinaryTree class?**
It is the topmost node and the entry point for all operations.

**3b. When a BinaryTree object is first created, what is the initial value of root?**
`null`.

**4. When the tree is empty and a new node is to be added, what process takes place?**
The new node becomes the root.

**5. Explain the add() method code block in detail.**
Smaller values are placed in the left subtree, larger values in the right subtree. This repeats until an empty position is found.

**6. Explain the steps in delete() when removing a node with two children. How does getSuccessor() assist?**
The node is replaced by its successor (the smallest value in its right subtree). `getSuccessor()` finds this replacement node.



# Experiment 2: Understanding Array-Based Binary Trees

Here are the plain-English, straightforward answers to how we can build a binary tree using a simple array instead of complex node links!

**1. What do the `data` and `idxLast` attributes actually do?**
* **`data`**: Think of this as a flat list that holds all our tree nodes (the students).
* **`idxLast`**: This is a bookmark that keeps track of the very last filled spot in our list. It tells the program exactly how big the tree is and prevents it from wandering into empty spaces.

**2. What is the job of the `populateData()` method?**
It’s the setup crew. It takes an existing list of students, loads them into our tree's array, and sets our `idxLast` bookmark. Once it's done, the tree is fully loaded and ready to be explored.

**3. What does `traverseInOrder()` do?**
It walks through the tree using the "In-Order" rule: Left child first, then the Parent, then the Right child. Because our tree is packed into a flat array, this method uses a neat math trick to figure out exactly where the children are hiding in the list.

**4. If a node lives at index 2, where are its kids?**
* **Left child:** Index 5 *(Math: 2 × 2 + 1)*
* **Right child:** Index 6 *(Math: 2 × 2 + 2)*

**5. Why set `idxLast = 6` in step 4?**
It simply tells the program, "Hey, the valid data ends exactly at index 6." Since arrays can have empty slots at the end, this acts as a boundary so the program doesn't try to read blank data or crash.

**6. Why do we use the formulas `2 * i + 1` and `2 * i + 2`?**
These formulas are the secret sauce of array-based trees! When you flatten a tree level-by-level into an array, the math works out perfectly. A left child is always at `2*i + 1` and a right child at `2*i + 2`. It saves memory because we don't need to create complex "pointers" or links to connect the nodes—the math does the connecting for us!
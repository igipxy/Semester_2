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
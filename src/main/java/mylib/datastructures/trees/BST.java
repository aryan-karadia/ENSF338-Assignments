package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    // This class is the implementation of the Binary Search Tree (BST) for integer data
    // The BST is implemented using a TNode class

    protected TNode root;

    // default constructor
    public BST() {
        this.root = null;
    }

    // constructor with int value

    public BST(int data) {
        this.root = new TNode();
        this.root.setData(data);
    }

    // constructor with TNode

    public BST(TNode obj) {
        this.root = obj;
    }

    // setter and getter for root

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    // creates a new node with data val to be inserted into the tree
    public void insert(int val) {
        TNode newNode = new TNode(val, null, null, null, 0);
        insert(newNode);
    }

    // inserts the node passed as argument into the tree
    public void insert(TNode newNode) {
        TNode temp = this.root;
        TNode parent = null;
        while (temp != null) {
            parent = temp;
            if (newNode.getData() < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        newNode.setParent(parent);
        if (parent == null) {
            this.root = newNode;
        } else if (newNode.getData() < parent.getData()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    // finds the node with val as data and deletes it, if not found prints
    //a statement that the value is not in the tree
    public void delete(int val) {
        this.root = deleteHelper(this.root, val);
    }

    private TNode deleteHelper(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree.");
            return null;
        }

        if (val < node.getData()) {
            node.setLeft(deleteHelper(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(deleteHelper(node.getRight(), val));
        } else {
            // node with val as data found, proceed to delete it
            if (node.getLeft() == null && node.getRight() == null) {
                // case 1: node is a leaf node
                return null;
            } else if (node.getLeft() == null) {
                // case 2: node has only one child (right)
                return node.getRight();
            } else if (node.getRight() == null) {
                // case 2: node has only one child (left)
                return node.getLeft();
            } else {
                // case 3: node has two children
                // find the smallest node in the right subtree (successor)
                TNode successor = findMin(node.getRight());
                // replace the data of node with the data of the successor
                node.setData(successor.getData());
                // delete the successor from the right subtree
                node.setRight(deleteHelper(node.getRight(), successor.getData()));
            }
        }

        return node;
    }

    private TNode findMin(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // searches for the node with val as adata and returens it or returns null if not found
    public TNode search(int val) {
        TNode temp = this.root;
        while (temp != null) {
            if (val == temp.getData()) {
                return temp;
            } else if (val < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return null;
    }

    // prints the tree in ascending order
    public void printInOrder() {
        printInOrderHelper(this.root);
        System.out.println();
    }

    private void printInOrderHelper(TNode node) {
        if (node != null) {
            printInOrderHelper(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrderHelper(node.getRight());
        }
    }

    // prints the content of the tree in Breadth-First order, each level of the tree will be printed on a separate line
    public void printBF() {
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.poll();
                assert current != null;
                System.out.print(current.getData() + " ");

                if (current.getLeft() != null) {
                    queue.offer(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.offer(current.getRight());
                }
            }
            System.out.println(); // print a new line after each level
        }
    }
}

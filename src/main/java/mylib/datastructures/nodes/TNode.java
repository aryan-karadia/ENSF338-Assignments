package mylib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    public TNode(int data, TNode left, TNode right, TNode parent, int balance) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }

    // Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // methods
    public void print() {
        System.out.println("Data: " + this.data);
        System.out.println("Balance: " + this.balance);
        System.out.println("Left: " + (this.left == null ? "null" : this.left.data));
        System.out.println("Right: " + (this.right == null ? "null" : this.right.data));
        System.out.println("Parent: " + (this.parent == null ? "null" : this.parent.data));
    }

    // returns the data member as a string (will be used for the tree prints)
    public String toString() {
        return String.valueOf(this.data);
    }

}

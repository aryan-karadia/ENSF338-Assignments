package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    public AVL() {
        super();
    }

    public AVL(int data) {
        super(data);
    }

    // if the TNode obj has children,
    //the constructor needs to create a balanced tree from passed tree by one
    //of the two following options:
    //• iteratively inserting nodes from the original tree and balancing the
    //new created AVL tree
    //• implementing a full tree balancing algorithm
    public AVL(TNode obj) {
        this.root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            // If the passed node has children, create a new AVL tree and balance it
            TNode newRoot = copyTree(obj);
            this.root = newRoot;
            balanceTree(newRoot);
        }
    }

    private TNode copyTree(TNode node) {
        if (node == null) {
            return null;
        }
        TNode newNode = new TNode(node.getData(), null, null, null, 0);
        newNode.setLeft(copyTree(node.getLeft()));
        newNode.setRight(copyTree(node.getRight()));
        return newNode;
    }

    private void balanceTree(TNode node) {
        if (node == null) {
            return;
        }
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.getLeft()) >= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (getBalance(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        balanceTree(node.getLeft());
        balanceTree(node.getRight());
    }

    private int getBalance(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private void updateHeight(TNode node) {
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            // If the new root node has children, create a new AVL tree and balance it
            TNode newRoot = copyTree(node);
            this.root = newRoot;
            balanceTree(newRoot);
        }
    }

    public void insert(int val) {
        if (this.root == null) {
            this.root = new TNode(val, null, null, null, 0);
            return;
        }
        super.insert(val);
        balanceTree(this.root);
    }

    public void insert(TNode newNode) {
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        super.insert(newNode);
        balanceTree(this.root);
    }

    public void delete(int val) {
        super.delete(val);
        balanceTree(this.root);
    }

    public TNode search(int val) {
        return super.search(val);
    }

    public void printInOrder() {
        super.printInOrder();
    }

    public void printBF() {
        super.printBF();
    }
}

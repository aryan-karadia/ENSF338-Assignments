package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    /**
     * Default constructor
     */
    public AVL() {
        super();
    }

    /**
     * Constructor with int value
     * @param data the value of the root node
     */
    public AVL(int data) {
        super(data);
    }

    // if the TNode obj has children,
    //the constructor needs to create a balanced tree from passed tree by one
    //of the two following options:
    //• iteratively inserting nodes from the original tree and balancing the
    //new created AVL tree
    //• implementing a full tree balancing algorithm

    /**
     * Constructor with TNode
     * @param obj the root node of the tree
     */
    public AVL(TNode obj) {
        this.root = obj;
        if (obj.getLeft() != null || obj.getRight() != null) {
            // If the passed node has children, create a new AVL tree and balance it
            TNode newRoot = copyTree(obj);
            this.root = newRoot;
            balanceTree(newRoot);
        }
    }

    /**
     * Copy the tree rooted at node
     * @param node the root of the tree to copy
     * @return the root of the copied tree
     */
    private TNode copyTree(TNode node) {
        if (node == null) {
            return null;
        }
        TNode newNode = new TNode(node.getData(), null, null, null, 0);
        newNode.setLeft(copyTree(node.getLeft()));
        newNode.setRight(copyTree(node.getRight()));
        return newNode;
    }

    /**
     * Balances the tree rooted at node
     * @param node the root of the tree
     */
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

    /**
     * Gets the balance of the tree rooted at node
     * @param node the root of the tree
     * @return the root of the tree
     */
    private int getBalance(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    /**
     * Gets the height of the tree rooted at node
     * @param node the root of the tree
     * @return the height of the tree
     */
    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    /**
     * Rotates the tree rooted at node to the right
     * @param node the root of the tree
     * @return the new root of the tree
     */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * Rotates the tree rooted at node to the left
     * @param node the root of the tree
     * @return the new root of the tree
     */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * Updates the balance factor of the tree rooted at node
     * @param node the root of the tree
     */
    private void updateHeight(TNode node) {
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
    }

    /**
     * Gets the root of the tree
     * @return the root of the tree
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * Sets the root of the tree
     * @param node the new root of the tree
     */
    public void setRoot(TNode node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            // If the new root node has children, create a new AVL tree and balance it
            TNode newRoot = copyTree(node);
            this.root = newRoot;
            balanceTree(newRoot);
        }
    }

    /**
     * Inserts a new node with value val into the tree
     * @param val the value of the new node
     */
    public void insert(int val) {
        if (this.root == null) {
            this.root = new TNode(val, null, null, null, 0);
            return;
        }
        super.insert(val);
        balanceTree(this.root);
    }

    /**
     * Inserts a new node into the tree
     * @param newNode the new node to insert
     */
    public void insert(TNode newNode) {
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        super.insert(newNode);
        balanceTree(this.root);
    }

    /**
     * Deletes the node with value val from the tree
     * @param val the value of the node to delete
     */
    public void delete(int val) {
        super.delete(val);
        balanceTree(this.root);
    }

    /**
     * Searches for the node with value val in the tree
     * @param val the value of the node to search for
     * @return the node with value val
     */
    public TNode search(int val) {
        return super.search(val);
    }

    /**
     * Prints the tree in order
     */
    public void printInOrder() {
        super.printInOrder();
    }

    /**
     * Prints the tree in pre-order
     */
    public void printBF() {
        super.printBF();
    }
}

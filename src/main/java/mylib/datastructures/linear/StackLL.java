package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    /**
     * Default constructor
     */
    public StackLL() {
        super();
    }

    /**
     * Constructor with head node
     * @param head the head node
     */
    public StackLL(SNode head) {
        super(head);
    }

    /**
     * Push a node onto the stack
     * @param node the node to push
     */
    public void push(SNode node) {
        this.insertHead(node);
    }

    /**
     * Pop a node off the stack
     * @return the node popped
     */
    public SNode pop() {
        SNode node = this.head;
        this.head = this.head.next;
        this.size--;
        return node;
    }

    /**
     * Peek at the top of the stack
     * @return the node at the top of the stack
     */
    public SNode peek() {
        return this.head;
    }

    /**
     * Display the stack
     */
    public void display() {
        super.print();
    }

    /**
     * Clear the stack
     */
    public void clear() {
        super.clear();
    }

    /**
     * Insert a node at the head of the list
     * @param node the node to insert
     * @param pos the position to insert the node
     */
    public void insert(SNode node, int pos) {

    }

    /**
     * Insert a node at the Tail of the list
     * @param node the node to insert
     */
    public void insertTail(SNode node) {

    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks if the list is sorted
     * @return true if the list is sorted, false otherwise
     */
    public boolean isSorted() {
        return true;
    }

    /**
     * Sort the list
     */
    public void sort() {

    }

    /**
     * Delete the head node
     */
    public void deleteHead() {

    }

    /**
     * Delete the tail node
     */
    public void deleteTail() {

    }

    /**
     * Delete a node at a given position
     * @param node the node to delete
     */
    public void delete(SNode node) {

    }

    /**
     * Sorted insert a node into the list
     * @param node the node to insert
     */
    public void sortedInsert(SNode node) {

    }
}

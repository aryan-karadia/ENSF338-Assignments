package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

    /**
     * Default constructor
     */
        public QueueLL() {
            super();
        }

    /**
     * Constructor with head node
     * @param head the head node
     */
    public QueueLL(SNode head) {
            super(head);
        }

    /**
     * Enqueue a node which means to insert it at the tail of the list
     * @param node
     */
        public void enqueue(SNode node) {
            this.insertTail(node);
        }

    /**
     * Dequeue a node which means to remove it from the head of the list
     * @return the node removed
     */
        public SNode dequeue() {
            SNode temp = this.head;
            super.deleteHead();
            return temp;
        }

    /**
     * Peek at the head of the list
     * @return the head node
     */
        public SNode peek() {
            return this.head;
        }

    /**
     * Display the list
     */
        public void display() {
            super.print();
        }

    /**
     * Clear the list
     */
        public void clear() {
            super.clear();
        }

    /**
     * Insert a node at a given position
     * @param node the node to insert
     * @param pos the position to insert the node
     */
        public void insert(SNode node, int pos) {

        }

    /**
     * Insert a node at the Tail of the list
     * @param node
     */
    public void insertTail(SNode node) {

        }

    /**
     * If the list is empty
     * @return that the list is empty or equal to 0
     */
        public boolean isEmpty() {
            return this.size == 0;
        }

    /**
     * If the list is sorted
     * @return true
     */
        public boolean isSorted() {
            return true;
        }

    /**
     * Sort the list
     * @return the sorted list
     */
        public void sort() {


        }

}

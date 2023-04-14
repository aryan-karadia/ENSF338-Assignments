package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    private DNode head;
    private DNode tail;
    private int size;

    /**
     * Constructs an empty circular doubly linked list.
     */
    public CDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a circular doubly linked list with a single node.
     * @param head the head of the list
     */
    public CDLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.head.prev = tail;
        this.tail.next = head;
        this.size = 1;
    }

    /**
     * Inserts a node at the head of the list.
     * @param node the node to insert
     */
    public void insertHead(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.head.prev = this.tail;
        this.tail.next = this.head;
        this.size++;
    }

    /**
     * Inserts a node at the tail of the list.
     * @param node the node to insert
     */
    public void insertTail(DNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        this.head.prev = this.tail;
        this.tail.next = this.head;
        this.size++;
    }

    /**
     * Inserts a node at a given position in the list.
     * @param node the node to insert
     * @param pos the position to insert the node at (0-indexed)
     */
    public void insert(DNode node, int pos) {
        super.insert(node, pos);
    }

    /**
     * Checks if the list is sorted.
     */
    public boolean isSorted() {
        DNode curr = this.head;
        for (int i = 0; i < this.size - 1; i++) {
            if (curr.value > curr.next.value) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    /**
     * Searches for a node in the list.
     * @param node the node to search for
     */
    public DNode search(DNode node) {
        DNode curr = this.head;
        for (int i = 0; i < this.size; i++) {
            if (curr.value == node.value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * Deletes the head of the list.
     */
    public void deleteHead() {
        if (this.head == null) {
            throw new NullPointerException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
        this.size--;
    }

    /**
     * Deletes the tail of the list.
     */
    public void deleteTail() {
        if (this.head == null) {
            throw new NullPointerException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = this.head;
            this.head.prev = this.tail;
        }
        this.size--;
    }

    /**
     * Deletes a node from the list.
     * @param node the node to delete
     */
    public boolean delete(DNode node) {
        if (this.head == null) {
            throw new NullPointerException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else if (this.head == node) {
            this.deleteHead();
        } else if (this.tail == node) {
            this.deleteTail();
        } else {
            DNode curr = this.head;
            for (int i = 0; i < this.size; i++) {
                if (curr == node) {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    this.size--;
                    break;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    /**
     * Sorts the list.
     */
    public void sort() {
        if (this.size <= 1 || isSorted()) {
            return; // list is already sorted
        }
        DNode curr = this.head;
        DNode next = curr.next;
        DNode temp;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if (curr.value > next.value) {
                    temp = curr;
                    curr = next;
                    next = temp;
                }
                curr = curr.next;
                next = next.next;
            }
            curr = this.head;
            next = curr.next;
        }
    }

    /**
     * Clears the list.
     */
    public void clear() {
        super.clear();
    }

    /**
     * Prints the list.
     */
    public void print() {
        super.print();
    }

    /**
     * Gets the head of the list.
     */
    public DNode getHead() {
        return this.head;
    }

    /**
     * Gets the tail of the list.
     */
    public DNode getTail() {
        return this.tail;
    }

    /**
     * Gets the size of the list.
     */
    public int getSize() {
        return this.size;
    }
}

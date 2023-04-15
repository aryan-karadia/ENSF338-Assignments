package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    /**
     * Constructs an empty circular doubly linked list.
     */
    public CDLL() {
        super.head = null;
        super.tail = null;
        super.size = 0;
    }

    /**
     * Constructs a circular doubly linked list with a single node.
     * @param head the head of the list
     */
    public CDLL(DNode head) {
        super.head = head;
        super.tail = head;
        super.head.prev = tail;
        super.tail.next = head;
        super.size = 1;
    }

    /**
     * Inserts a node at the head of the list.
     * @param node the node to insert
     */
    public void insertHead(DNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
        } else {
            node.next = super.head;
            super.head.prev = node;
            super.head = node;
        }
        super.head.prev = super.tail;
        super.tail.next = super.head;
        super.size++;
    }

    /**
     * Inserts a node at the tail of the list.
     * @param node the node to insert
     */
    public void insertTail(DNode node) {
        if (super.head == null) {
            super.head = node;
        } else {
            super.tail.next = node;
            node.prev = super.tail;
        }
        super.tail = node;
        super.head.prev = super.tail;
        super.tail.next = super.head;
        super.size++;
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
        DNode curr = super.head;
        for (int i = 0; i < super.size - 1; i++) {
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
        DNode curr = super.head;
        for (int i = 0; i < super.size; i++) {
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
        if (super.head == null) {
            throw new NullPointerException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else {
            super.head = super.head.next;
            super.head.prev = super.tail;
            super.tail.next = super.head;
        }
        super.size--;
    }

    /**
     * Deletes the tail of the list.
     */
    public void deleteTail() {
        if (super.head == null) {
            throw new NullPointerException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else {
            super.tail = super.tail.prev;
            super.tail.next = super.head;
            super.head.prev = super.tail;
        }
        super.size--;
    }

    /**
     * Deletes a node from the list.
     * @param node the node to delete
     */
    public boolean delete(DNode node) {
        if (super.head == null) {
            throw new NullPointerException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else if (super.head == node) {
            this.deleteHead();
        } else if (super.tail == node) {
            this.deleteTail();
        } else {
            DNode curr = super.head;
            for (int i = 0; i < super.size; i++) {
                if (curr == node) {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    super.size--;
                    return true;
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
        if (super.size <= 1 || isSorted()) {
            return; // list is already sorted
        }
        DNode curr = super.head;
        DNode next = curr.next;
        DNode temp;
        for (int i = 0; i < super.size; i++) {
            for (int j = 0; j < super.size - 1; j++) {
                if (curr.value > next.value) {
                    temp = curr;
                    curr = next;
                    next = temp;
                }
                curr = curr.next;
                next = next.next;
            }
            curr = super.head;
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
        return super.head;
    }

    /**
     * Gets the tail of the list.
     */
    public DNode getTail() {
        return super.tail;
    }

    /**
     * Gets the size of the list.
     */
    public int getSize() {
        return super.size;
    }
}

package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

import java.util.NoSuchElementException;

public class CSLL extends SLL {

    private SNode head;
    private SNode tail;
    private int size;

    /**
     * Constructs an empty circular singly linked list.
     */
    public CSLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs a circular singly linked list with a single node.
     * @param head the head of the list
     */
    public CSLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    /**
     * Inserts a node at the head of the list.
     * @param node the node to insert
     */
    public void insertHead(SNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.next = node;
        } else {
            node.next = this.head;
            this.head = node;
            this.tail.next = this.head;
        }
        this.size++;
    }

    /**
     * Inserts a node at the tail of the list.
     * @param node the node to insert
     */
    public void insertTail(SNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.next = node;
        } else {
            this.tail.next = node;
            this.tail = node;
            this.tail.next = this.head;
        }
        this.size++;
    }

    /**
     * Inserts a node at a given position in the list.
     * @param node the node to insert
     * @param pos the position to insert the node at
     */
    public void insert(SNode node, int pos) {
        super.insert(node, pos);
    }

    /**
     * Inserts a node into a sorted list.
     * @param node the node to insert
     */
    public void sortedInsert(SNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.next = node;
        } else if (this.head.value >= node.value) {
            this.insertHead(node);
        } else if (this.tail.value <= node.value) {
            this.insertTail(node);
        } else {
            SNode prev = this.head;
            while (prev.next.value < node.value) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            this.size++;
        }
    }

    /**
     * Deletes a node from the list.
     * @param node the node to delete
     */
    public boolean isSorted() {
        if (this.head != null) {
            SNode prev = this.head;
            SNode curr = this.head.next;
            while (curr != this.head) {
                if (prev.value > curr.value) {
                    return false;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return true;
    }

    /**
     * Searches for a node in the list.
     * @param node the node to search for
     */
    public SNode search(SNode node) {
        if (this.head != null) {
            SNode curr = this.head;
            while (curr != this.tail) {
                if (curr.value == node.value) {
                    return curr;
                }
                curr = curr.next;
            }
            if (curr.value == node.value) {
                return curr;
            }
        }
        return null;
    }

    /**
     * Deletes the head of the list.
     */
    public void deleteHead() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.tail.next = this.head;
        }
        this.size--;
    }

    /**
     * Deletes the tail of the list.
     */
    public void deleteTail() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            SNode prev = this.head;
            while (prev.next != this.tail) {
                prev = prev.next;
            }
            prev.next = this.head;
            this.tail = prev;
        }
        this.size--;
    }

    /**
     * Deletes a node at a given position in the list.
     * @param node the position to delete the node at
     */
    public void delete(SNode node) {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else if (this.head == node) {
            this.deleteHead();
        } else if (this.tail == node) {
            this.deleteTail();
        } else {
            SNode prev = this.head;
            while (prev.next != node) {
                prev = prev.next;
            }
            prev.next = node.next;
        }
        this.size--;
    }

    /**
     * Sorts the list.
     */
    public void sort() {
        if (this.size <= 1 || isSorted()) {
            return;
        }
        SNode prev = this.head;
        SNode curr = this.head.next;
        SNode next = this.head.next.next;
        while (curr != this.head) {
            if (prev.value > curr.value) {
                prev.next = next;
                curr.next = this.head;
                this.head = curr;
            } else {
                prev = curr;
            }
            curr = next;
            next = next.next;
        }
    }

    /**
     * Removes The Head of the list.
     */
    public SNode removeHead() {
        if (isEmpty()) {
            return null;
        }
        SNode removedNode = head;
        if (head == tail) {
            // there is only one node in the list
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head; // make the tail point to the new head
        }
        size--;
        return removedNode;
    }

    /**
     * Removes The Tail of the list.
     */
    public SNode removeTail() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (getSize() == 1) {
            head = null;
            tail = null;
            size = 0;
            return null;
        }
        SNode curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        curr.next = head;
        tail = curr;
        size--;
        return curr;
    }

    /**
     * Checks if the list is empty.
     * @returns true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Removes a node from the list.
     * @param node the node to remove
     */
    public SNode remove(SNode node) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (head == node) {
            removeHead();
        } else if (tail == node) {
            removeTail();
        } else {
            SNode curr = head;
            while (curr.next != node) {
                curr = curr.next;
            }
            curr.next = node.next;
            size--;
        }
        return node;
    }

    /**
     * Checks if the list contains a node.
     * @param node the node to check for
     * @returns true if the list contains the node, false otherwise
     */
    public boolean contains(SNode node) {
        if (this.head != null) {
            SNode curr = this.head;
            while (curr != this.tail) {
                if (curr == node) {
                    return true;
                }
                curr = curr.next;
            }
            return curr == node;
        }
        return false;
    }

    /**
     * Gets the Node at a given position.
     * @param pos the position of the node to get
     * @returns the node at the given position
     */
    public SNode getNode(int pos) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        SNode curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr;
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
}

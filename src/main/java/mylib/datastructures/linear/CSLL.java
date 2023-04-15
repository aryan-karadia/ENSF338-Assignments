package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

import java.util.NoSuchElementException;

public class CSLL extends SLL {

    public CSLL() {
        super.head = null;
        super.tail = null;
        super.size = 0;
    }

    public CSLL(SNode head) {
        super.head = head;
        super.tail = head;
        super.size = 1;
    }

    public void insertHead(SNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
            super.head.next = node;
        } else {
            node.next = super.head;
            super.head = node;
            super.tail.next = super.head;
        }
        super.size++;
    }

    public void insertTail(SNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
            node.next = node;
        } else {
            super.tail.next = node;
            super.tail = node;
            super.tail.next = super.head;
        }
        super.size++;
    }

    public void insert(SNode node, int pos) {
        super.insert(node, pos);
    }

    public void sortedInsert(SNode node) {
        if (super.head == null) {
            super.head = node;
            super.tail = node;
            node.next = node;
            super.size++;
        } else if (super.head.value >= node.value) {
            this.insertHead(node);
        } else if (super.tail.value <= node.value) {
            this.insertTail(node);
        } else {
            SNode prev = super.head;
            while (prev.next.value < node.value) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            super.size++;
        }
    }

    public boolean isSorted() {
        if (super.head != null) {
            SNode prev = super.head;
            SNode curr = super.head.next;
            while (curr != super.head) {
                if (prev.value > curr.value) {
                    return false;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return true;
    }

    public SNode search(SNode node) {
        if (super.head != null) {
            SNode curr = super.head;
            while (curr != super.tail) {
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

    public void deleteHead() {
        if (super.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else {
            super.head = super.head.next;
            super.tail.next = super.head;
        }
        super.size--;
    }

    public void deleteTail() {
        if (super.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else {
            SNode prev = super.head;
            while (prev.next != super.tail) {
                prev = prev.next;
            }
            prev.next = super.head;
            super.tail = prev;
        }
        super.size--;
    }

    public void delete(SNode node) {
        if (super.head == null) {
            throw new IndexOutOfBoundsException();
        } else if (super.head == super.tail) {
            super.head = null;
            super.tail = null;
        } else if (super.head == node) {
            this.deleteHead();
        } else if (super.tail == node) {
            this.deleteTail();
        } else {
            SNode prev = super.head;
            while (prev.next != node) {
                prev = prev.next;
            }
            prev.next = node.next;
        }
        super.size--;
    }

    public void sort() {
        if (super.size <= 1 || isSorted()) {
            return;
        }
        SNode prev = super.head;
        SNode curr = super.head.next;
        SNode next = super.head.next.next;
        while (curr != super.head) {
            if (prev.value > curr.value) {
                prev.next = next;
                curr.next = super.head;
                super.head = curr;
            } else {
                prev = curr;
            }
            curr = next;
            next = next.next;
        }
    }

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
        SNode temp = tail;
        curr.next = head;
        super.tail = curr;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return super.head == null;
    }

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

    public boolean contains(SNode node) {
        if (super.head != null) {
            SNode curr = super.head;
            while (curr != super.tail) {
                if (curr == node) {
                    return true;
                }
                curr = curr.next;
            }
            return curr == node;
        }
        return false;
    }

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

    public void clear() {
        super.clear();
    }


    public void print() {
        super.print();
    }

    public int getSize() {
        return super.size;
    }

    public SNode getHead() {
        return super.head;
    }

    public SNode getTail() {
        return super.tail;
    }
}

package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    private SNode head;
    private SNode tail;
    private int size;

    public CSLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public CSLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

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

    public void insert(SNode node, int pos) {
        super.insert(node, pos);
    }

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
                curr = next;
                next = next.next;
            } else {
                prev = curr;
                curr = next;
                next = next.next;
            }
        }
    }

    public void clear() {
        super.clear();
    }

    public void print() {
        super.print();
    }
}

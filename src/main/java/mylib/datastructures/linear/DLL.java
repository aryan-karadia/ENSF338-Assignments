package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.SNode;

public class DLL {

    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public void insertHead(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;

        }
        this.size++;
    }

    public void insertTail(DNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        this.size++;
    }

    public void insert(DNode node, int pos) {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            this.insertHead(node);
        } else if (pos == this.size) {
            this.insertTail(node);
        } else {
            DNode prev = this.head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            node.prev = prev;
            prev.next.prev = node;
            prev.next = node;
            this.size++;
        }
    }

    public boolean isSorted() {
        DNode curr = this.head;
        while (curr.next != null) {
            if (curr.value > curr.next.value) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public DNode search(DNode node) {
        DNode curr = this.head;
        while (curr != null) {
            if (curr.value == node.value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void deleteHead() {
        if (this.head == null) {
            throw new NullPointerException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
    }

    public void deleteTail() {
        if (this.head == null) {
            throw new NullPointerException();
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    public void delete(DNode node) {
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
            while (curr != null) {
                if (curr == node) {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    this.size--;
                    break;
                }
                curr = curr.next;
            }
        }
    }

    public void sort() {
        if (this.size <= 1 || isSorted()) {
            return; // list is already sorted
        }

        DNode prev = this.head;
        DNode curr = prev.next;
        while (curr != null) {
            DNode insertPos = findInsertPosition(curr);

            if (insertPos != prev) {
                // remove curr from its current position and insert it at insertPos
                curr.prev.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                curr.next = insertPos.next;
                curr.prev = insertPos;
                insertPos.next = curr;
                if (curr.next != null) {
                    curr.next.prev = curr;
                }

                // update curr to the next unsorted node
                curr = prev.next;
            } else {
                // curr is already in the correct position, move on to the next unsorted node
                prev = curr;
                curr = curr.next;
            }
        }
    }

    private DNode findInsertPosition(DNode node) {
        DNode curr = this.head;
        DNode prev = null;
        while (curr != node && curr.value < node.value) {
            prev = curr;
            curr = curr.next;
        }
        return prev != null ? prev : this.head;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void print() {
        DNode current = head;
        int length = 0;

        // Check if the list is empty
        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        // Traverse the list and print each node's value
        System.out.print("List content: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
            length++;
        }
        System.out.println();

        // Print the list length
        System.out.println("List length: " + length);

        // Check if the list is sorted
        boolean sorted = isSorted();
        System.out.println("Sorted status: " + (sorted ? "sorted" : "unsorted"));
    }

    public DNode getHead() {
        return head;
    }

    public DNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}

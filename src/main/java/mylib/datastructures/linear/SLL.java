package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class SLL {
    SNode head;
    private SNode tail;
    int size;


    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public void insertHead(SNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void insertTail(SNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        this.size++;
    }

    public void insert(SNode node, int pos) {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            this.insertHead(node);
        } else if (pos == this.size) {
            this.insertTail(node);
        } else {
            SNode prev = this.head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            this.size++;
        }
    }

    public void sortedInsert(SNode node) {
        if (!isSorted()) {
            sort();
        }
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else if (node.value < this.head.value) {
            this.insertHead(node);
        } else if (node.value > this.tail.value) {
            this.insertTail(node);
        } else {
            SNode curr = this.head;
            while (curr.next != null && curr.next.value < node.value) {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
            this.size++;
        }
    }

    private boolean isSorted() {
        if (this.head == null) {
            return true;
        }
        SNode curr = this.head;
        while (curr.next != null) {
            if (curr.value > curr.next.value) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public SNode search(SNode node) {
        SNode curr = this.head;
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
            SNode curr = this.head;
            while (curr.next != this.tail) {
                curr = curr.next;
            }
            curr.next = null;
            this.tail = curr;
        }
        this.size--;
    }

    public void delete(SNode node) {
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
            SNode curr = this.head;
            while (curr.next != node) {
                curr = curr.next;
            }
            curr.next = node.next;
            this.size--;
        }
    }

    public void sort() {
        if (this.size <= 1 || isSorted()) {
            return; // list is already sorted
        }

        SNode prev = this.head;
        SNode curr = prev.next;
        while (curr != null) {
            SNode insertPos = findInsertPosition(curr);

            if (insertPos != prev) {
                // remove curr from its current position and insert it at insertPos
                prev.next = curr.next;
                curr.next = insertPos.next;
                insertPos.next = curr;

                // update curr to the next unsorted node
                curr = prev.next;
            } else {
                // curr is already in the correct position, move on to the next unsorted node
                prev = curr;
                curr = curr.next;
            }
        }
    }

    private SNode findInsertPosition(SNode node) {
        SNode curr = this.head;
        SNode prev = null;
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
        SNode current = head;
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

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        SNode prevNode = null;
        SNode currNode = head;
        SNode nextNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        tail = head;
        head = prevNode;
    }


    // getters and setters

    public SNode getHead() {
        return head;
    }

    public SNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

}
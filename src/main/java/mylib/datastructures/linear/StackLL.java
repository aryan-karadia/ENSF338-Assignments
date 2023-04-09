package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }

    public StackLL(SNode head) {
        super(head);
    }

    public void push(SNode node) {
        this.insertHead(node);
    }

    public SNode pop() {
        SNode node = this.head;
        this.head = this.head.next;
        this.size--;
        return node;
    }

    public SNode peek() {
        return this.head;
    }

    public void display() {
        super.print();
    }

    public void clear() {
        super.clear();
    }

    public void insert(SNode node, int pos) {

    }

    public void insertTail(SNode node) {

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isSorted() {
        return true;
    }

    public void sort() {

    }

    public void deleteHead() {

    }

    public void deleteTail() {

    }

    public void delete(SNode node) {

    }

    public void sortedInsert(SNode node) {

    }
}

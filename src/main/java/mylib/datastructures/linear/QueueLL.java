package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL {

        public QueueLL() {
            super();
        }

        public QueueLL(SNode head) {
            super(head);
        }

        public void enqueue(SNode node) {
            super.insertTail(node);
        }

        public SNode dequeue() {
            SNode temp = this.head;
            super.deleteHead();
            return temp;
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

}

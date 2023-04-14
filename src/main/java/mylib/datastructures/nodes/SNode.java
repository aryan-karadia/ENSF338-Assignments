package mylib.datastructures.nodes;

public class SNode {
    public int value;
    public SNode next;

    public SNode(int value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(SNode nextNode) {
        this.next = nextNode;
    }


}

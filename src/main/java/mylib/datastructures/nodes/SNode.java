package mylib.datastructures.nodes;

public class SNode {
    public int value;
    public SNode next;

    /**
     * Constructor for SNode
     * @param value the value of the node
     */
    public SNode(int value) {
        this.value = value;
        this.next = null;
    }
    /**
     * Constructor for SNode
     * @param nextNode the next node in the list
     */
    public void setNext(SNode nextNode) {
        this.next = nextNode;
    }


}

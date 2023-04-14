package mylib.datastructures.nodes;

public class DNode {
    public int value;
    public DNode next;
    public DNode prev;

    /**
     * Constructor for a DNode
     * @param value the value to be stored in the node
     */
    public DNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    /**
     * Constructor for a DNode
     */
    public DNode() {
        this.value = 0;
        this.next = null;
        this.prev = null;
    }
}

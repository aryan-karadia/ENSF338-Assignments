
import mylib.datastructures.linear.CDLL;
import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.linear.SLL;
import mylib.datastructures.linear.StackLL;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.SNode;
import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import mylib.datastructures.trees.BST;
import mylib.datastructures.nodes.SNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    /** Testing SLL **/
    @Test
    public void testInsertHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testInsertTail() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testInsert() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);

        sll.insert(new SNode(3), 1);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 2);

        sll.insert(new SNode(2), 1);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), -1);
    }

    @Test
    public void testSortedInsert() {
        SLL sll = new SLL();
        sll.sortedInsert(new SNode(2));
        sll.sortedInsert(new SNode(1));
        sll.sortedInsert(new SNode(3));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 3);
    }

    @Test
    public void testSearch() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        assertEquals(sll.search(node1), node1);
        assertEquals(sll.search(node2), node2);
        assertNull(sll.search(new SNode(3)));
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteHeadWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteHead();
    }

    @Test
    public void testDeleteHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteHead();
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteTailWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteTail();
    }
    @Test
    public void testDeleteTail() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteTail();
        assertEquals(sll.getHead().value, 2);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        sll.delete(new SNode(1)); // delete the node with value 1
    }

    @Test
    public void testDelete() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        sll.insert(new SNode(2), 1);
        sll.insert(new SNode(3), 2);
        sll.delete(new SNode(1)); // delete the node with value 1
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 2);
    }

    @Test
    public void testReverse() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertTail(new SNode(2));
        sll.insertTail(new SNode(3));
        sll.reverse();
        assertEquals(sll.getHead().value, 3);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 3);
    }


    /** Testing DLL **/

}

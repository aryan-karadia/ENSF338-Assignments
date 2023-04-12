import mylib.datastructures.linear.SLL;
import mylib.datastructures.nodes.SNode;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.nodes.DNode;

import mylib.datastructures.linear.CSLL;
import mylib.datastructures.nodes.SNode;

import mylib.datastructures.linear.CDLL;
import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.linear.StackLL;
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
    public void testSLLInsertHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testSLLInsertTail() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testSLLInsert() {
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
    public void testSLLInsertWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), -1);
    }

    @Test
    public void testSLLSortedInsert() {
        SLL sll = new SLL();
        sll.sortedInsert(new SNode(2));
        sll.sortedInsert(new SNode(1));
        sll.sortedInsert(new SNode(3));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 3);
    }

    @Test
    public void testSLLSearch() {
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
    public void testSLLDeleteHeadWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteHead();
    }

    @Test
    public void testSLLDeleteHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteHead();
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSLLDeleteTailWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteTail();
    }
    @Test
    public void testSLLDeleteTail() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteTail();
        assertEquals(sll.getHead().value, 2);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSLLDeleteWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        sll.delete(new SNode(1)); // delete the node with value 1
    }

    @Test
    public void testSLLDelete() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        sll.insert(node1, 0);
        sll.insert(new SNode(2), 1);
        sll.insert(new SNode(3), 2);
        sll.delete(node1); // delete the node with value 1
        assertEquals(1, sll.getHead().value);
        assertEquals(3, sll.getTail().value);
        assertEquals(2, sll.getSize());
    }

    @Test
    public void testSLLReverse() {
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
    @Test
    public void testDLLInsert() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Insert at position
        DNode node4 = new DNode(4);
        dll.insert(node4, 1);
        assertEquals(4, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node1, node2.next);
        assertEquals(node4, node1.next);
        assertEquals(node2, node4.prev);
        assertEquals(node1, node3.prev);
    }

    @Test
    public void testDLLDelete() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node3);
        dll.insertHead(node2);
        dll.insertHead(node1);
        assertEquals(3, dll.getSize());

        // Delete head
        dll.deleteHead();
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Delete tail
        dll.deleteTail();
        assertEquals(1, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node2, dll.getTail());

        // Delete at position
        dll.delete(node2);
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());

        // Test deleting from empty list
        try {
            dll.deleteHead();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Test passed
        }
    }

    @Test
    public void testDLLIsSorted() {
        DLL dll = new DLL();

        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node3);
        dll.insertHead(node1);
        dll.insertHead(node2);
        assertFalse(dll.isSorted());

        dll.sort();
        assertTrue(dll.isSorted());
    }

    @Test
    public void testDLLSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        dll.insertHead(node1);
        assertEquals(node1, dll.search(node1));
        assertEquals(node2, dll.search(node2));
        assertNull(dll.search(new DNode(3)));
    }

    @Test
    public void testDLLSort() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        dll.insertHead(node3);
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertTail(node4);

        dll.sort();
        assertEquals(node1, dll.getHead());
        assertEquals(node2, node1.next);
        assertEquals(node3, node2.next);
        assertEquals(node4, dll.getTail());
        assertTrue(dll.isSorted());
    }
    @Test
    public void testDLLInsertAndClear() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Insert at position
        DNode node4 = new DNode(4);
        dll.insert(node4, 1);
        assertEquals(4, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node1, node2.next);
        assertEquals(node4, node1.next);
        assertEquals(node2, node4.prev);
        assertEquals(node1, node3.prev);

        // Clear the list
        dll.clear();
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());

        // Insert after clear
        DNode node5 = new DNode(5);
        dll.insertHead(node5);
        assertEquals(1, dll.getSize());
        assertEquals(node5, dll.getHead());
        assertEquals(node5, dll.getTail());
    }

    @Test
    public void testDLLSequenceOfInsertsAndDeletes() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Delete at tail
        dll.deleteTail();
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Delete at head
        dll.deleteHead();
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Delete at position
        dll.delete(node1);
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    /** Testing CSLL **/

    @Test
    public void testEmptyConstructor() {
        CSLL list = new CSLL();
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testSingleNodeConstructor() {
        SNode node = new SNode(42);
        CSLL list = new CSLL(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
    }

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        SNode node = new SNode(42);
        list.insertHead(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        SNode node2 = new SNode(13);
        list.insertHead(node2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node, list.getTail());
    }

    @Test
    public void testInsertTail() {
        CSLL list = new CSLL();
        SNode node = new SNode(42);
        list.insertTail(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        SNode node2 = new SNode(13);
        list.insertTail(node2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testInsertAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insert(node1, 0);
        list.insert(node2, 1);
        list.insert(node3, 1);
        assertFalse(list.isEmpty());
        assertEquals(3, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getHead().next);
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testSortedInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        SNode node4 = new SNode(99);
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        list.sortedInsert(node3);
        list.sortedInsert(node4);
        assertFalse(list.isEmpty());
        assertEquals(4, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getHead().next);
        assertEquals(node1, list.getHead().next.next);
        assertEquals(node4, list.getTail());
    }

    @Test
    public void testRemoveHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.removeHead();
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(node3, removedNode);
    }

    @Test
    public void testRemoveTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.removeTail();
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(node1, removedNode);
    }

    @Test
    public void testRemoveAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.remove(new SNode(13)); // pass the node to be removed
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(node2, removedNode);
    }


    @Test
    public void testGetNodeAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode nodeAtPos1 = list.getNode(1);
        assertEquals(node2, nodeAtPos1);
        SNode nodeAtPos2 = list.getNode(2);
        assertEquals(node1, nodeAtPos2);
    }

    @Test
    public void testClearList() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testContains() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        assertFalse(list.contains(node3));
        list.insertHead(node3);
        assertTrue(list.contains(node3));
    }

    /** Testing CDLL Class**/
}

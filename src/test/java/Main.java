
import mylib.datastructures.linear.CDLL;
import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.linear.SLL;
import mylib.datastructures.linear.StackLL;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.SNode;
import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import mylib.datastructures.trees.BST;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    @Test
    public void testInsertHead() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertHead(node1);
        assertEquals(node1, sll.getHead());
        assertEquals(node1, sll.getTail());
        assertEquals(1, sll.getSize());

        sll.insertHead(node2);
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getTail());
        assertEquals(2, sll.getSize());

        sll.insertHead(node3);
        assertEquals(node3, sll.getHead());
        assertEquals(node1, sll.getTail());
        assertEquals(3, sll.getSize());
    }

    @Test
    public void testInsertTail() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertTail(node1);
        assertEquals(node1, sll.getHead());
        assertEquals(node1, sll.getTail());
        assertEquals(1, sll.getSize());

        sll.insertTail(node2);
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getTail());
        assertEquals(2, sll.getSize());

        sll.insertTail(node3);
        assertEquals(node1, sll.getHead());
        assertEquals(node3, sll.getTail());
        assertEquals(3, sll.getSize());
    }

    @Test
    public void testInsertAtBeginning() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SLL list = new SLL(node2);
        list.insert(node1, 0);
        assertEquals(list.getHead(), node1);
        assertEquals(list.getTail(), node2);
        assertEquals(list.getSize(), 2);
    }

    @Test
    public void testInsertAtEnd() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SLL list = new SLL(node1);
        list.insert(node2, 1);
        assertEquals(list.getHead(), node1);
        assertEquals(list.getTail(), node2);
        assertEquals(list.getSize(), 2);
    }

    @Test
    public void testInsertAtMiddle() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SLL list = new SLL(node1);
        list.insert(node3, 1);
        list.insert(node2, 1);
        assertEquals(list.getHead(), node1);
        assertEquals(list.getTail(), node3);
        assertEquals(list.getSize(), 3);
        assertEquals(list.getHead().next, node2);
        assertEquals(list.getHead().next.next, node3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds() {
        SNode node1 = new SNode(1);
        SLL list = new SLL(node1);
        list.insert(new SNode(2), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertNegativePosition() {
        SNode node1 = new SNode(1);
        SLL list = new SLL(node1);
        list.insert(new SNode(2), -1);
    }

    @Test
    public void testSortedInsertAtBeginning() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.sortedInsert(node2);
        list.sortedInsert(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getHead().next);
        assertEquals(2, list.getSize());
    }

    @Test
    public void testSortedInsertAtEnd() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getHead().next);
        assertEquals(2, list.getSize());
    }

    @Test
    public void testSortedInsertAtMiddle() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.sortedInsert(node3);
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getHead().next);
        assertEquals(node3, list.getHead().next.next);
        assertEquals(3, list.getSize());
    }

    @Test
    public void testSearch() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        sll.insertTail(new SNode(2));
        sll.insertTail(new SNode(3));
        sll.insertTail(new SNode(4));

        SNode nodeToFind = new SNode(2);
        SNode foundNode = sll.search(nodeToFind);

        assertEquals(nodeToFind, foundNode);
    }

    @Test
    public void testDeleteHead() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        sll.insertTail(new SNode(2));
        sll.insertTail(new SNode(3));
        sll.insertTail(new SNode(4));

        sll.deleteHead();

        assertEquals(3, sll.getSize());
        assertEquals(2, sll.getHead().value);
    }

    @Test
    public void testDeleteTail() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        sll.insertTail(new SNode(2));
        sll.insertTail(new SNode(3));
        sll.insertTail(new SNode(4));

        sll.deleteTail();

        assertEquals(3, sll.getSize());
        assertEquals(3, sll.getTail().value);
    }

    @Test
    public void testDelete() {
        SLL sll = new SLL();
        SNode nodeToDelete = new SNode(2);

        sll.insertTail(new SNode(1));
        sll.insertTail(nodeToDelete);
        sll.insertTail(new SNode(3));
        sll.insertTail(new SNode(4));

        sll.delete(nodeToDelete);

        assertEquals(3, sll.getSize());
        assertNull(sll.search(nodeToDelete));
    }

    @Test
    public void testSort() {
        SLL list = new SLL();
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(4));
        list.insertTail(new SNode(2));
        list.sort();
        assertEquals(1, list.getHead().value);
        assertEquals(2, list.getHead().next.value);
        assertEquals(3, list.getHead().next.next.value);
        assertEquals(4, list.getHead().next.next.next.value);
    }

    @Test
    public void testClear() {
        SLL list = new SLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));
        list.clear();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testPrint() {
        SLL list = new SLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(2));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List content: 1 2 \nList length: 2\nSorted status: sorted\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testInsertHead2() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        // Insert node1 at the head
        list.insertHead(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());

        // Insert node2 at the head
        list.insertHead(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getSize());

        // Insert node3 at the head
        list.insertHead(node3);
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test
    void testInsertTail2() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        // Insert node1 at the tail
        list.insertTail(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());

        // Insert node2 at the tail
        list.insertTail(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());

        // Insert node3 at the tail
        list.insertTail(node3);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(3, list.getSize());
    }

    @Test
    void testCDLLMethods() {
        // Create a CDLL with nodes 5, 7, 10
        CDLL cdll = new CDLL(new DNode(5));
        cdll.insertTail(new DNode(7));
        cdll.insertTail(new DNode(10));

        // Test isSorted() - should return true
        assert cdll.isSorted();

        // Test search() - search for node with value 7, should return node with value 7
        DNode searchResult = cdll.search(new DNode(7));
        assert searchResult.value == 7;

        // Test deleteHead() - delete head node (5)
        cdll.deleteHead();
        assert cdll.getHead().value == 7;
        assert cdll.getTail().next.value == 7;

        // Test deleteTail() - delete tail node (10)
        cdll.deleteTail();
        assert cdll.getTail().value == 7;
        assert cdll.getHead().prev.value == 7;

        // Test delete() - delete node with value 7
        DNode nodeToDelete = cdll.search(new DNode(7));
        cdll.delete(nodeToDelete);
        assert cdll.getHead().value == cdll.getTail().value;
        assert cdll.getSize() == 1;

        // Test sort() - sort the list in ascending order
        cdll.insertTail(new DNode(3));
        cdll.insertTail(new DNode(8));
        cdll.insertTail(new DNode(1));
        cdll.sort();
        assert cdll.isSorted();
        assert cdll.getHead().value == 1;
        assert cdll.getTail().value == 8;
    }

    @Test
    void testPush() {
        StackLL stack = new StackLL();
        stack.push(new SNode(1));
        stack.push(new SNode(2));
        stack.push(new SNode(3));
        assertEquals(3, stack.getSize());
        assertEquals(3, stack.pop().value);
        assertEquals(2, stack.pop().value);
        assertEquals(1, stack.pop().value);
        assertEquals(0, stack.getSize());
    }

    @Test
    void testPop() {
        StackLL stack = new StackLL();
        stack.push(new SNode(1));
        stack.push(new SNode(2));
        stack.push(new SNode(3));
        assertEquals(3, stack.pop().value);
        assertEquals(2, stack.pop().value);
        assertEquals(1, stack.pop().value);
        assertEquals(0, stack.getSize());
    }

    @Test
    void testPeek() {
        StackLL stack = new StackLL();
        stack.push(new SNode(1));
        stack.push(new SNode(2));
        stack.push(new SNode(3));
        assertEquals(3, stack.peek().value);
        stack.pop();
        assertEquals(2, stack.peek().value);
        stack.pop();
        assertEquals(1, stack.peek().value);
    }

    @Test
    void testDisplay() {
        StackLL stack = new StackLL();
        stack.push(new SNode(1));
        stack.push(new SNode(2));
        stack.push(new SNode(3));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        stack.display();
        assertEquals("3 -> 2 -> 1 -> null\n", outContent.toString());
    }

    @Test
    void testClear2() {
        StackLL stack = new StackLL();
        stack.push(new SNode(1));
        stack.push(new SNode(2));
        stack.push(new SNode(3));
        assertEquals(3, stack.getSize());
        stack.clear();
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty2() {
        StackLL stack = new StackLL();
        assertTrue(stack.isEmpty());
        stack.push(new SNode(1));
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsSorted() {
        StackLL stack = new StackLL();
        assertTrue(stack.isSorted());
    }

    @Test
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        queue.enqueue(node1);
        assertEquals(node1, queue.peek());

        queue.enqueue(node2);
        assertEquals(node1, queue.peek());

        queue.enqueue(node3);
        assertEquals(node1, queue.peek());

        assertEquals(3, queue.getSize());
    }

    @Test
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);

        SNode dequeuedNode1 = queue.dequeue();
        assertEquals(node1, dequeuedNode1);
        assertEquals(node2, queue.peek());
        assertEquals(2, queue.getSize());

        SNode dequeuedNode2 = queue.dequeue();
        assertEquals(node2, dequeuedNode2);
        assertEquals(node3, queue.peek());
        assertEquals(1, queue.getSize());

        SNode dequeuedNode3 = queue.dequeue();
        assertEquals(node3, dequeuedNode3);
        assertNull(queue.peek());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void testIsEmpty() {
        QueueLL queue = new QueueLL();
        assertTrue(queue.isEmpty());

        SNode node = new SNode(1);
        queue.enqueue(node);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testConstructor() {
        BST tree = new BST();
        assertNull(tree.getRoot());
    }

    @Test
    public void testInsert() {
        BST tree = new BST(5);
        assertEquals(5, tree.getRoot().getData());

        tree.insert(3);
        assertEquals(3, tree.getRoot().getLeft().getData());

        tree.insert(7);
        assertEquals(7, tree.getRoot().getRight().getData());

        tree.insert(1);
        assertEquals(1, tree.getRoot().getLeft().getLeft().getData());

        tree.insert(9);
        assertEquals(9, tree.getRoot().getRight().getRight().getData());

        tree.insert(4);
        assertEquals(4, tree.getRoot().getLeft().getRight().getData());

        tree.insert(2);
        assertEquals(2, tree.getRoot().getLeft().getLeft().getRight().getData());
    }


    @Test
    public void testDelete2() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.delete(5);

        assertNull(bst.search(5));
        assertNotNull(bst.search(2));
        assertNotNull(bst.search(3));
        assertNotNull(bst.search(4));
        assertNotNull(bst.search(6));
        assertNotNull(bst.search(7));
        assertNotNull(bst.search(8));

        bst.delete(10);
        assertNotNull(bst.search(2));
        assertNotNull(bst.search(3));
        assertNotNull(bst.search(4));
        assertNotNull(bst.search(6));
        assertNotNull(bst.search(7));
        assertNotNull(bst.search(8));
    }

    @Test
    public void testSearch2() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertNotNull(bst.search(5));
        assertNotNull(bst.search(2));
        assertNotNull(bst.search(3));
        assertNotNull(bst.search(4));
        assertNotNull(bst.search(6));
        assertNotNull(bst.search(7));
        assertNotNull(bst.search(8));
        assertNull(bst.search(10));
    }

    @Test
    public void testPrintInOrder() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.printInOrder(); // should print "2 3 4 5 6 7 8"
    }

    @Test
    public void testPrintBF() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.printBF(); // should print "5 \n 3 7 \n 2 4 6 8"
    }

    @Test
    public void testConstructorAVL() {
        AVL avl1 = new AVL();
        assertNull(avl1.getRoot());

        AVL avl2 = new AVL(5);
        assertEquals(5, avl2.getRoot().getData());

        // create a binary search tree
        BST bst = new BST(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // create a new AVL tree from the binary search tree
        AVL avl3 = new AVL(bst.getRoot());

        // ensure the AVL tree is balanced
        assertEquals(5, avl3.getRoot().getData());
        assertEquals(2, avl3.getRoot().getLeft().getData());
        assertEquals(7, avl3.getRoot().getRight().getData());
        assertEquals(1, avl3.getRoot().getLeft().getLeft().getData());
        assertEquals(4, avl3.getRoot().getLeft().getRight().getData());
        assertEquals(6, avl3.getRoot().getRight().getLeft().getData());
        assertEquals(8, avl3.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testGetterSetterAVL() {
        AVL avl = new AVL();
        assertNull(avl.getRoot());

        TNode root = new TNode(5, null, null, null, 0);
        avl.setRoot(root);
        assertEquals(5, avl.getRoot().getData());
    }

    @Test
    public void testInsertAVL() {
        AVL avl = new AVL();

        // insert values
        avl.insert(5);
        avl.insert(2);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);

        // ensure the AVL tree is balanced
        assertEquals(5, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(7, avl.getRoot().getRight().getData());
        assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(4, avl.getRoot().getLeft().getRight().getData());
        assertEquals(6, avl.getRoot().getRight().getLeft().getData());
        assertEquals(8, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testInsertNodeAVL() {
        AVL tree = new AVL();

        // Create a node with value 10
        TNode node = new TNode(10, null, null, null, 0);

        // Insert the node into the tree
        tree.insert(node);

        // Check that the node was inserted correctly
        assertEquals(10, tree.getRoot().getData());

        // Create a node with value 5
        node = new TNode(5, null, null, null, 0);

        // Insert the node into the tree
        tree.insert(node);

        // Check that the tree was balanced correctly
        assertEquals(5, tree.getRoot().getData());
        assertEquals(10, tree.getRoot().getRight().getData());
    }

    @Test
    public void testDeleteAVL() {
        AVL tree = new AVL();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        // Delete a leaf node
        tree.delete(1);
        assertEquals(null, tree.search(1));
        assertEquals(3, tree.getRoot().getLeft().getData());

        // Delete a node with one child
        tree.delete(2);
        assertEquals(null, tree.search(2));
        assertEquals(4, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());

        // Delete a node with two children
        tree.delete(4);
        assertEquals(null, tree.search(4));
        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(6, tree.getRoot().getRight().getData());
    }
}

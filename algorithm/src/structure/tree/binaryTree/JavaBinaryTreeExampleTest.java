package structure.tree.binaryTree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JavaBinaryTreeExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testAddition() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        assertFalse(binaryTreeExample.containsNode(24));
        assertEquals(binaryTreeExample.getSize(), 8);
        binaryTreeExample.add(24);
        assertTrue(binaryTreeExample.containsNode(24));
        assertEquals(binaryTreeExample.getSize(), 9);
    }

    @Test
    public void testIsEmpty() {
        JavaBinaryTreeExample emptyTree = new JavaBinaryTreeExample();
        assertTrue(emptyTree.isEmpty());
        JavaBinaryTreeExample notEmptyTree = createBinaryTree();
        assertFalse(notEmptyTree.isEmpty());
    }

    @Test
    public void testDeletion() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        assertEquals(binaryTreeExample.getSize(), 8);
        assertTrue(binaryTreeExample.containsNode(60));
        binaryTreeExample.delete(60);
        assertEquals(binaryTreeExample.getSize(), 7);
        assertFalse(binaryTreeExample.containsNode(60));
    }

    @Test
    public void test_duplicateElementAddition() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        assertEquals(binaryTreeExample.getSize(), 8);
        assertTrue(binaryTreeExample.containsNode(60));
        binaryTreeExample.add(60); // 60 already exists
        // 60 is not added again
        assertEquals(binaryTreeExample.getSize(), 8);
    }

    @Test
    public void testInOrderTraversal() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        binaryTreeExample.inOrderTraversal(binaryTreeExample.root);
        assertEquals(" 7 10 17 20 29 55 60 99", outContent.toString());
    }

    @Test
    public void testPreOrderTraversal() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        binaryTreeExample.preOrderTraversal(binaryTreeExample.root);
        assertEquals(" 20 7 17 10 29 60 55 99", outContent.toString());
    }

    @Test
    public void testPostOrderTraversal() {
        JavaBinaryTreeExample binaryTreeExample = createBinaryTree();
        binaryTreeExample.postOrderTraversal(binaryTreeExample.root);
        assertEquals(" 10 17 7 55 99 60 29 20", outContent.toString());
    }

    private JavaBinaryTreeExample createBinaryTree() {
        JavaBinaryTreeExample binaryTree = new JavaBinaryTreeExample();

        binaryTree.add(20);
        binaryTree.add(29);
        binaryTree.add(7);
        binaryTree.add(60);
        binaryTree.add(17);
        binaryTree.add(99);
        binaryTree.add(10);
        binaryTree.add(55);

        return binaryTree;
    }


}

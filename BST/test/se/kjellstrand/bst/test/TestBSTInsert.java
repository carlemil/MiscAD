
package se.kjellstrand.bst.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import se.kjellstrand.bst.BST;
import se.kjellstrand.bst.Node;

public class TestBSTInsert {

    BST bstTree = new BST();

    public TestBSTInsert() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertOneNode() {
        bstTree.insert(new Node(1));
        long size = bstTree.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void insertManyNodes1() {
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));
        bstTree.insert(new Node(7));

        long size = bstTree.size();
        Assert.assertEquals(7, size);
    }

    @Test
    public void getInorder() {
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));
        bstTree.insert(new Node(7));

        long[] list = bstTree.getInOrderListOfKeys();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            sb.append(list[i]+", ");
        }
        System.out.println(sb);
        for (int i = 1; i < list.length; i++) {
            Assert.assertEquals(i, list[i]);
        }
    }

}

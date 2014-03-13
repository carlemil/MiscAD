
package se.kjellstrand.bst.test;

import java.util.ArrayList;

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
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(7));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));
        // This is what the BST should
        // look like after the inserts
        // --------3---------
        // ----1-------5-----
        // ------2---4---7---
        // -------------6----
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertOneNode() {
        bstTree.insert(new Node(8));
        long size = bstTree.size();
        Assert.assertEquals(8, size);
    }

    @Test
    public void getInorder() {
        ArrayList<Integer> list = bstTree.getInOrderListOfKeys();
        Integer[] keys = list.toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[] {
                1, 2, 3, 4, 5, 6, 7
        }, keys);
    }

    @Test
    public void getPreorder() {
        ArrayList<Integer> list = bstTree.getPreOrderListOfKeys();
        Integer[] keys = list.toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[] {
                3, 1, 2, 5, 4, 7, 6
        }, keys);
    }

    @Test
    public void find() {
        Assert.assertEquals(1, bstTree.find(1).getKey());
        Assert.assertEquals(2, bstTree.find(2).getKey());
        Assert.assertEquals(3, bstTree.find(3).getKey());
        Assert.assertEquals(6, bstTree.find(6).getKey());
        Assert.assertEquals(7, bstTree.find(7).getKey());
        Assert.assertEquals(null, bstTree.find(8));
    }

    @Test
    public void deleteNodeWithNoChildren() {
        Assert.assertEquals(2, bstTree.find(2).getKey());
        bstTree.delete(2);
        Assert.assertEquals(null, bstTree.find(2));
    }

    @Test
    public void deleteNodeWithOneChild() {
        Assert.assertEquals(1, bstTree.find(1).getKey());
        bstTree.delete(1);
        Assert.assertEquals(null, bstTree.find(1));

        Assert.assertEquals(1, bstTree.find(7).getKey());
        bstTree.delete(7);
        Assert.assertEquals(null, bstTree.find(7));
    }

}

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
        bstTree.insert(new Node());
        long size = bstTree.size();
        Assert.assertEquals(1, size);
    }

}

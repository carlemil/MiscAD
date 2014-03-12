
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
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(7));
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));

        ArrayList<Integer> list = bstTree.getInOrderListOfKeys();

        StringBuilder sb = new StringBuilder();
        for (Integer key : list) {
            sb.append(key + ", ");
        }
        System.out.println(sb);
        Integer[] keys = list.toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[] {
                1, 2, 3, 4, 5, 6, 7
        }, keys);
    }

    @Test
    public void getPreorder() {
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(7));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));

        ArrayList<Integer> list = bstTree.getPreOrderListOfKeys();

        StringBuilder sb = new StringBuilder();
        for (Integer key : list) {
            sb.append(key + ", ");
        }
        System.out.println(sb);
        Integer[] keys = list.toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[] {
                3, 1, 2, 5, 4, 7, 6
        }, keys);
    }

    @Test
    public void find() {
        bstTree.insert(new Node(3));
        bstTree.insert(new Node(5));
        bstTree.insert(new Node(1));
        bstTree.insert(new Node(4));
        bstTree.insert(new Node(7));
        bstTree.insert(new Node(2));
        bstTree.insert(new Node(6));

        Assert.assertEquals(1, bstTree.find(1).k);
        Assert.assertEquals(2, bstTree.find(2).k);
        Assert.assertEquals(3, bstTree.find(3).k);
        Assert.assertEquals(6, bstTree.find(6).k);
        Assert.assertEquals(7, bstTree.find(7).k);
        Assert.assertEquals(null, bstTree.find(8));
    }
}


package se.kjellstrand.bst;

import java.util.ArrayList;

public class BST {

    private Node root;

    public void insert(Node node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    public void insert(Node current, Node node) {
        if (node.k < current.k) {
            if (current.l == null) {
                current.l = node;
            } else {
                insert(current.l, node);
            }
        } else {
            if (current.r == null) {
                current.r = node;
            } else {
                insert(current.r, node);
            }
        }
    }

    public Node find(int key) {
        return find(root, key);
    }

    private Node find(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.k == key) {
            return node;
        } else if (node.k > key) {
            return find(node.l, key);
        } else if (node.k < key) {
            return find(node.r, key);
        }
        return null;
    }

    public void delete(int key) {

    }

    public int size() {
        return root.size();
    }

    public ArrayList<Integer> getInOrderListOfKeys() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getInorderListOfKeys(list, root);
        return list;
    }

    private void getInorderListOfKeys(ArrayList<Integer> list, Node node) {
        if (node.l != null) {
            getInorderListOfKeys(list, node.l);
        }
        list.add(node.k);
        if (node.r != null) {
            getInorderListOfKeys(list, node.r);
        }
    }

    public ArrayList<Integer> getPreOrderListOfKeys() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getPreOrderListOfKeys(list, root);
        return list;
    }

    private void getPreOrderListOfKeys(ArrayList<Integer> list, Node node) {
        list.add(node.k);

        if (node.l != null) {
            getPreOrderListOfKeys(list, node.l);
        }
        if (node.r != null) {
            getPreOrderListOfKeys(list, node.r);
        }
    }

}

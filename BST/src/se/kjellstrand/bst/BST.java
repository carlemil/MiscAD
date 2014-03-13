
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
        if (node.getKey() < current.getKey()) {
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                insert(current.getLeft(), node);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(node);
            } else {
                insert(current.getRight(), node);
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
        if (node.getKey() == key) {
            return node;
        } else if (node.getKey() > key) {
            return find(node.getLeft(), key);
        } else if (node.getKey() < key) {
            return find(node.getRight(), key);
        }
        return null;
    }

    public void delete(int key) {
        Node node = find(key);
        // Deleting a leaf (node with no children): Deleting a leaf is easy, as
        // we can simply remove it from the tree.
        if (node.getLeft() == null && node.getRight() == null) {
            Node parent = node.getParent();
            if (parent.getLeft() != null && parent.getLeft().equals(node)) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else
        // Deleting a node with one child: Remove the node and replace it
        // with its child.
        if (node.getLeft() != null ^ node.getRight() != null) {
            Node parent = node.getParent();
            Node child = node.getLeft();
            if (child == null) {
                child = node.getRight();
            }
            if (parent.getLeft() != null && parent.getLeft().equals(node)) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        } else
        // Deleting a node with two children: Call the node to be deleted N. Do
        // not delete N. Instead, choose either its in-order successor node or
        // its in-order predecessor node, R. Replace the value of N with the
        // value of R, then delete R.
        {

        }
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
        if (node.getLeft() != null) {
            getInorderListOfKeys(list, node.getLeft());
        }
        list.add(node.getKey());
        if (node.getRight() != null) {
            getInorderListOfKeys(list, node.getRight());
        }
    }

    public ArrayList<Integer> getPreOrderListOfKeys() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getPreOrderListOfKeys(list, root);
        return list;
    }

    private void getPreOrderListOfKeys(ArrayList<Integer> list, Node node) {
        list.add(node.getKey());

        if (node.getLeft() != null) {
            getPreOrderListOfKeys(list, node.getLeft());
        }
        if (node.getRight() != null) {
            getPreOrderListOfKeys(list, node.getRight());
        }
    }

}

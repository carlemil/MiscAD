
package se.kjellstrand.bst;

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

    public long size() {
        return root.size();
    }

    public long[] getInOrderListOfKeys() {

        long[] list = new long[(int) size()];
        getInorderListOfKeys(list, root, 0);
        return null;
    }

    private int getInorderListOfKeys(long[] list, Node node, int i) {
        if (node.l != null) {
            i = getInorderListOfKeys(list, node.l, i);
        }
        list[i] = node.k;
        i++;
        if (node.r != null) {
            i = getInorderListOfKeys(list, node.r, i);
        }
        return i;
    }

}

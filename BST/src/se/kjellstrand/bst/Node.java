package se.kjellstrand.bst;

public class Node {
    public int k;
    public Node l;
    public Node r;

    public Node(int key){
        k=key;
    }

    public int size() {
        int ls = 0;
        int rs = 0;
        if (l != null) {
            ls = l.size();
        }
        if (r != null) {
            rs = r.size();
        }
        return 1 + rs + ls;
    }

}

package se.kjellstrand.bst;

public class Node {
    public long k;
    public Node l;
    public Node r;

    public Node(long key){
        k=key;
    }

    public long size() {
        long ls = 0;
        long rs = 0;
        if (l != null) {
            ls = l.size();
        }
        if (r != null) {
            rs = r.size();
        }
        return 1 + rs + ls;
    }

}

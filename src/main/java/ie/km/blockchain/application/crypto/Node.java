package ie.km.blockchain.application.crypto;

public  class Node {
    private final Node left;
    private final Node right;
    private final byte[] hash;
    private final int depth;
    private boolean isLeaf;

    private Node(Node left, Node right, byte[] hash, int depth, boolean isLeaf) {
        this.left = left;
        this.right = right;
        this.hash = hash;
        this.depth = depth;
        this.isLeaf = isLeaf;
    }

    public Node(Node left, Node right, byte[] hash, int depth) {
        this(left, right, hash, depth, false);
    }

    public Node(byte[] hash, int depth) {
        this(null, null, hash, depth, true);
    }

    public byte[] getHash() {
        return hash;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isLeaf() {
        return isLeaf;
    }
}

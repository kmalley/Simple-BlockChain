package ie.km.blockchain.application.crypto;

import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Simple implementation of a Merkle tree
 *
 * Adding 6 transaction A, B, C, D, E, F results in the tree:
 *
 *             ABCDEF
 *              /   \
 *            /      \
 *          /         \
 *        ABCD        EF
 *       /   \         |
 *     /      \        |
 *   AB       CD      EF
 *  /  \     /  \    /  \
 * A    B   C   D   E    F
 */
public class MerkleTree {

    private final Logger logger = Logger.getLogger(MerkleTree.class.getName());

    private Set<byte[]> hashList;

    private Node root;

    private LinkedList<Node> nodes = new LinkedList<>();

    public MerkleTree(Set<byte[]> hashList) {
        logger.info("Creating new MerkleTree with " + hashList.size() + " nodes");
        this.hashList = hashList;
    }

    public Node build() {
        hashList.forEach(entry -> nodes.add(new Node(entry, 0)));
        buildTree();
        System.out.println("Root node=" + new String(root.getHash()));
        return root;
    }

    private void buildTree() {
        while (!nodes.isEmpty()) {
            logger.info("Remaining nodes=" + nodes.size());

            Node left = nodes.remove();

            //
            // To ensure the tree is balanced both the left and right nodes should be at the same depth
            // To balance the tree a new node is added to the head of the queue with the same details as the
            // unbalanced leaf node
            if (left.getDepth() != nodes.peek().getDepth()) {
                logger.info("Tree is not balanced!" + " l.depth=" + left.getDepth() + " r.depth=" + nodes.peek().getDepth());
                Node n = new Node(left.getHash(), left.getDepth());

                nodes.addFirst(n);
            }

            Node right = nodes.remove();

            byte[] combined = combineByteArrays(left.getHash(), right.getHash());

            Node parent = new Node(left, right, Encoder.digest(combined), left.getDepth() + 1);

            if (nodes.isEmpty()) {
                root = parent; // root node
                return;
            }
            nodes.add(parent);
        }

    }

    private byte[] combineByteArrays(byte[] aArray, byte[] bArray) {
        byte[] combined = new byte[aArray.length + bArray.length];
        System.arraycopy(aArray, 0, combined, 0, aArray.length);
        System.arraycopy(bArray, 0, combined, aArray.length, bArray.length);
        return combined;
    }


}

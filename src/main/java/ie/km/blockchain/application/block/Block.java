package ie.km.blockchain.application.block;

import ie.km.blockchain.application.block.domain.Account;
import ie.km.blockchain.application.block.domain.SimpleTransaction;
import ie.km.blockchain.application.crypto.Encoder;
import ie.km.blockchain.application.crypto.HashCash;
import ie.km.blockchain.application.crypto.MerkleTree;
import ie.km.blockchain.application.crypto.Node;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Block {

    private final static int MAX_NUM_TRANSACTIONS = 6;

    private final String previousHash;

    private Map<byte[], SimpleTransaction> transactionMap = new HashMap<>();

    private MerkleTree angela;

    private Node root;

    private String proofOfWork;

    private int transactionCounter = 0;

    Block(byte[] previousHash) {
        this.previousHash = new String(previousHash);
    }

    public boolean isBlockFull() {
        return (transactionCounter == MAX_NUM_TRANSACTIONS);
    }

    public String addTransaction(SimpleTransaction t) {
        if (!isBlockFull()) {
            transactionCounter++;
            byte[] transHash = Encoder.digest(t.toString().getBytes());

            String hashAsString = Encoder.encode(transHash);
            transactionMap.put(transHash, t);
            System.out.println("Hash=" + hashAsString);
            return hashAsString;
        } else throw new RuntimeException("Block full");
    }

    public Node mineBlock() {
        angela = new MerkleTree(transactionMap.keySet());
        root = angela.build();
        System.out.println("Root hash=" + Encoder.encode(root.getHash()));
        proofOfWork = generateProofOfWork();
        return root;
    }

    private String generateProofOfWork() {
        HashCash hc = new HashCash("1", 20, "170115", String.valueOf(previousHash + new String(root.getHash())));
        return hc.mint();
    }

    public boolean isMined() {
        return proofOfWork != null;
    }

    public Set<byte[]> getTransactionHashList() {
        return transactionMap.keySet();
    }
    public Node getRoot() {
        return root;
    }

    public MerkleTree getMerkleTree() {
        return angela;
    }

    public int getNumberOfTransactions() {
        return transactionMap.size();
    }

    protected static Block createGenesisBlock() {
        Block b = new Block("/mttCtevLaG1GsBa0azSACs9S5uoYw7xVy9QxfJwbiU=".getBytes());
        b.addTransaction(new SimpleTransaction(Account.create(), Account.create(), 100L));
        b.addTransaction(new SimpleTransaction(Account.create(), Account.create(), 200L));
        b.mineBlock();
        return b;
    }

}

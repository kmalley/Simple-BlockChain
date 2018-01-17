package ie.km.blockchain.application.block;

import ie.km.blockchain.application.block.domain.Account;
import ie.km.blockchain.application.block.domain.Transaction;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;

public class BlockChain {

    private static Block genesis;

    private LinkedList<Block> chain = new LinkedList<>();

    private HashMap<String, Block> transactionMap = new HashMap<>();

    private Block activeBlock;

    public BlockChain() {
        genesis = Block.createGenesisBlock();
        chain.add(genesis);
    }

    private Block createBlock() {
        return new Block(chain.peekLast().getRoot().getHash());
    }


    public String processTransaction(Transaction transaction) {
        if (activeBlock == null) {
            activeBlock = createBlock();
        }

        String transactionHash = activeBlock.addTransaction(transaction);

        if (activeBlock.isBlockFull()) {
            activeBlock.mineBlock();
            //
            // Link each transaction to the block in the clain
            activeBlock.getTransactionHashList()
                    .forEach(trans -> transactionMap.put(new String(trans), activeBlock));
            //
            // Block complete so add it to the chain
            chain.add(activeBlock);
        }

        return transactionHash;
    }

    public static void main(String args[]) {
        BlockChain bc = new BlockChain();

        bc.processTransaction(new Transaction(Account.create(), Account.create(), 100L));
        bc.processTransaction(new Transaction(Account.create(), Account.create(), 200L));
        bc.processTransaction(new Transaction(Account.create(), Account.create(), 300L));
        bc.processTransaction(new Transaction(Account.create(), Account.create(), 400L));
        bc.processTransaction(new Transaction(Account.create(), Account.create(), 400L));
        bc.processTransaction(new Transaction(Account.create(), Account.create(), 500L));

    }

}

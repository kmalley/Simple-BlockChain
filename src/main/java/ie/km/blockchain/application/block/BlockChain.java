package ie.km.blockchain.application.block;

import ie.km.blockchain.application.block.domain.ComplexTransaction;
import ie.km.blockchain.application.block.domain.SimpleTransaction;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 */
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

    public String processTransaction(SimpleTransaction simpleTransaction) {
        if (activeBlock == null) {
            activeBlock = createBlock();
        }

        String transactionHash = activeBlock.addTransaction(simpleTransaction);

        if (activeBlock.isBlockFull()) {
            activeBlock.mineBlock();
            //
            // Link each simpleTransaction to the block in the chain
            activeBlock.getTransactionHashList()
                    .forEach(trans -> transactionMap.put(new String(trans), activeBlock));
            //
            // For convenience link the blocks root node to the transactionMap
            transactionMap.put(new String(activeBlock.getRoot().getHash()), activeBlock);

            //
            // Block complete so add it to the chain
            chain.add(activeBlock);
        }

        return transactionHash;
    }
//
//    /**
//     * For a transaction to be valid both the sender and receiver accounts must exist on the blockchain and the senders
//     * balance must be >= the amount + the transaction fee. In theory once you've got the longest chain the last
//     * transaction featuring the senders account
//     * @param transaction
//     * @return
//     */
//    private boolean isValid(SimpleTransaction transaction) {
//
//    }

    /**
     * A transaction is valid when:
     * - the input references an valid previous output on the chain
     * - the previous output has a spend value >= the spend amount + the transaction fee
     * - the transaction output contains a valid public key
     * @param transaction
     * @return
     */
    private boolean validate(ComplexTransaction transaction) {

        if (transactionMap.containsKey(transaction.getInput().getId())) {

        }
        return true;
    }

//    private boolean accountExists() {
//        transactionMap.values().forEach(t -> if(t.));
//    }

//    public boolean getTransactionStatus() {
//
//    }
//
//    public Block getBlock(String hash) {
//        return transactionMap.get(hash);
//    }
}

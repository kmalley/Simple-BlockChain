package ie.km.blockchain.application.block;

import ie.km.blockchain.application.block.domain.Account;
import ie.km.blockchain.application.block.domain.SimpleTransaction;
import org.junit.Test;

public class BlockChainTest {

    @Test
    public void processTransaction() {
        BlockChain bc = new BlockChain();

        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 100L));
        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 200L));
        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 300L));
        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 400L));
        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 400L));
        bc.processTransaction(new SimpleTransaction(Account.create(), Account.create(), 500L));
    }
}
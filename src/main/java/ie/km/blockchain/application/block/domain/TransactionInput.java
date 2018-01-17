package ie.km.blockchain.application.block.domain;

import java.util.Arrays;
import java.util.List;

public class TransactionInput {
    public String id;
    public ScriptSig scriptSig;
    private final List<TransactionOutput> outputs;

    public TransactionInput(TransactionOutput...outputs) {
        this.outputs = Arrays.asList(outputs);
    }

    public String getId() {
        return id;
    }
}

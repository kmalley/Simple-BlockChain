package ie.km.blockchain.application.block.domain;

public class TransactionInput {
    public String id;

    //
    // Proof of ownership
    public ScriptSig scriptSig;

    //
    // Reference to previous transaction with un-spent amount
    private final TransactionOutput outPoint;

    public TransactionInput(TransactionOutput outPoint) {
        this.outPoint= outPoint;
    }

    public String getId() {
        return id;
    }
}

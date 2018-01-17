package ie.km.blockchain.application.block.domain;

public class TransactionOutput {
    private String id;

    private final ScriptPubKey publicKey;

    private final long spendAmount;

    public TransactionOutput(ScriptPubKey publicKey, long spendAmount) {
        this.publicKey = publicKey;
        this.spendAmount = spendAmount;
    }

    public String getId() {
        return id;
    }
}

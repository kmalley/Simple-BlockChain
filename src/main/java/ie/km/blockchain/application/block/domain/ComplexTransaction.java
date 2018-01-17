package ie.km.blockchain.application.block.domain;

public class ComplexTransaction {

    private final TransactionInput input;

    private final long timestamp = System.currentTimeMillis();

    private final TransactionOutput output;

    public ComplexTransaction(TransactionInput input, TransactionOutput output) {
        this.input = input;
        this.output = output;
    }

    public TransactionInput getInput() {
        return input;
    }

    public TransactionOutput getOutput() {
        return output;
    }
}



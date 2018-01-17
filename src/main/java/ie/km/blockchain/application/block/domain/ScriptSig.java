package ie.km.blockchain.application.block.domain;

public class ScriptSig {
    private final String signature;

    public ScriptSig(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }
}

package ie.km.blockchain.application.block.domain;

public class ScriptPubKey {
    private final String publicKey;

    public ScriptPubKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }
}

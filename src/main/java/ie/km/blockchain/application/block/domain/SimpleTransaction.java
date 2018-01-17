package ie.km.blockchain.application.block.domain;

public class SimpleTransaction {
    private final Account sender;

    private final Account receiver;

    private final long amount;

    private long balance;

    private final long timestamp = System.currentTimeMillis();

    public SimpleTransaction(Account sender, Account receiver, Long amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        System.out.println("Creating " + toString());
    }

    public Long getAmount() {
        return amount;
    }

    public Account getReceiver() {
        return receiver;
    }

    public Account getSender() {
        return sender;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "SimpleTransaction{" +
                "sender='" + sender.getAccountNumber() + '\'' +
                ", receiver='" + receiver.getAccountNumber() + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}

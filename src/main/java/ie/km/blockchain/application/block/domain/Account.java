package ie.km.blockchain.application.block.domain;

import ie.km.blockchain.application.crypto.Encoder;

public class Account {
    private final String accountNumber;

    private Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static Account create() {
        return new Account(Encoder.encode(String.valueOf(System.currentTimeMillis()).getBytes()));
    }

}

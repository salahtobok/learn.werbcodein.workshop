package com.webcodein.bank.domain.model;

import java.math.BigDecimal;

public class Account {

    private final AccountId id;
    private BigDecimal balance;

    public Account(AccountId id, BigDecimal initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Cannot withdraw " + amount);
        }
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public AccountId getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

package com.webcodein.bank.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
class AccountJpaEntity {

    @Id
    private Long id;

    private BigDecimal balance;

    protected AccountJpaEntity() {
    }

    AccountJpaEntity(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    Long getId() {
        return id;
    }

    BigDecimal getBalance() {
        return balance;
    }
}

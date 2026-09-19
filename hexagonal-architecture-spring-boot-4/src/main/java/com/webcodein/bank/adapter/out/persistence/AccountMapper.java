package com.webcodein.bank.adapter.out.persistence;

import com.webcodein.bank.domain.model.Account;
import com.webcodein.bank.domain.model.AccountId;
import org.springframework.stereotype.Component;

@Component
class AccountMapper {

    Account mapToDomainEntity(AccountJpaEntity entity) {
        return new Account(new AccountId(entity.getId()), entity.getBalance());
    }

    AccountJpaEntity mapToJpaEntity(Account account) {
        return new AccountJpaEntity(account.getId().getValue(), account.getBalance());
    }
}

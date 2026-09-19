package com.webcodein.bank.domain.port.out;

import com.webcodein.bank.domain.model.Account;
import com.webcodein.bank.domain.model.AccountId;

public interface LoadAccountPort {

    Account loadAccount(AccountId id);
}

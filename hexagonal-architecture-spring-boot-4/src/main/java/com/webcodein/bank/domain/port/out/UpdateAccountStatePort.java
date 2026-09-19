package com.webcodein.bank.domain.port.out;

import com.webcodein.bank.domain.model.Account;

public interface UpdateAccountStatePort {

    void update(Account account);
}

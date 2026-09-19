package com.webcodein.bank.domain.service;

import com.webcodein.bank.domain.model.Account;
import com.webcodein.bank.domain.model.AccountId;
import com.webcodein.bank.domain.port.in.TransferMoneyUseCase;
import com.webcodein.bank.domain.port.out.LoadAccountPort;
import com.webcodein.bank.domain.port.out.UpdateAccountStatePort;
import java.math.BigDecimal;

/**
 * Plain Java: no Spring annotations in the domain. It is wired as a bean
 * in {@code DomainConfig}.
 */
public class TransferMoneyService implements TransferMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;

    public TransferMoneyService(LoadAccountPort loadAccountPort, UpdateAccountStatePort updateAccountStatePort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public boolean transfer(AccountId source, AccountId target, BigDecimal amount) {
        Account sourceAccount = loadAccountPort.loadAccount(source);
        Account targetAccount = loadAccountPort.loadAccount(target);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        updateAccountStatePort.update(sourceAccount);
        updateAccountStatePort.update(targetAccount);

        return true;
    }
}

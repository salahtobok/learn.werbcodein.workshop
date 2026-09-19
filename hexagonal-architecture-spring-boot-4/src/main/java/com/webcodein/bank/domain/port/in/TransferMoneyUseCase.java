package com.webcodein.bank.domain.port.in;

import com.webcodein.bank.domain.model.AccountId;
import java.math.BigDecimal;

public interface TransferMoneyUseCase {

    boolean transfer(AccountId source, AccountId target, BigDecimal amount);
}

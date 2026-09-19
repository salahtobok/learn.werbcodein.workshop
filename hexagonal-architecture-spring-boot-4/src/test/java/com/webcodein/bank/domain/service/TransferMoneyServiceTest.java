package com.webcodein.bank.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.webcodein.bank.domain.model.Account;
import com.webcodein.bank.domain.model.AccountId;
import com.webcodein.bank.domain.model.InsufficientFundsException;
import com.webcodein.bank.domain.port.out.LoadAccountPort;
import com.webcodein.bank.domain.port.out.UpdateAccountStatePort;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * The domain is tested without Spring, a database or mocks: the ports are
 * replaced by a tiny in-memory adapter.
 */
class TransferMoneyServiceTest {

    private final InMemoryAccounts accounts = new InMemoryAccounts();
    private final TransferMoneyService service = new TransferMoneyService(accounts, accounts);

    private final AccountId source = new AccountId(1L);
    private final AccountId target = new AccountId(2L);

    @Test
    void movesMoneyBetweenAccounts() {
        accounts.store.put(1L, new Account(source, new BigDecimal("100")));
        accounts.store.put(2L, new Account(target, new BigDecimal("10")));

        service.transfer(source, target, new BigDecimal("40"));

        assertThat(accounts.store.get(1L).getBalance()).isEqualByComparingTo("60");
        assertThat(accounts.store.get(2L).getBalance()).isEqualByComparingTo("50");
    }

    @Test
    void rejectsTransferWithInsufficientFunds() {
        accounts.store.put(1L, new Account(source, new BigDecimal("5")));
        accounts.store.put(2L, new Account(target, BigDecimal.ZERO));

        assertThatThrownBy(() -> service.transfer(source, target, new BigDecimal("40")))
            .isInstanceOf(InsufficientFundsException.class);
    }

    private static class InMemoryAccounts implements LoadAccountPort, UpdateAccountStatePort {

        final Map<Long, Account> store = new HashMap<>();

        @Override
        public Account loadAccount(AccountId id) {
            return store.get(id.getValue());
        }

        @Override
        public void update(Account account) {
            store.put(account.getId().getValue(), account);
        }
    }
}

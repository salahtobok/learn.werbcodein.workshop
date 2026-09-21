package com.webcodein.security.zerotrust.controller;

import com.webcodein.security.zerotrust.model.BalanceResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancialDataController {

    @GetMapping("/api/v1/accounts/{accountId}/balance")
    @PreAuthorize("hasAuthority('SCOPE_finance:read') and @securityService.isOwner(authentication, #accountId)")
    public BalanceResponse getBalance(@PathVariable String accountId) {
        // Business logic to retrieve balance
        return new BalanceResponse(accountId, 15000.00, "USD");
    }
}

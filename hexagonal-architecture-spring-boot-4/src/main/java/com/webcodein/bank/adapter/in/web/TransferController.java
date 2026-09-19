package com.webcodein.bank.adapter.in.web;

import com.webcodein.bank.domain.model.AccountId;
import com.webcodein.bank.domain.port.in.TransferMoneyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TransferController {

    private final TransferMoneyUseCase transferMoneyUseCase;

    TransferController(TransferMoneyUseCase transferMoneyUseCase) {
        this.transferMoneyUseCase = transferMoneyUseCase;
    }

    @PostMapping("/api/transfers")
    void transfer(@RequestBody TransferRequest request) {
        // Map request to domain IDs, then execute use case
        transferMoneyUseCase.transfer(
            new AccountId(request.source()),
            new AccountId(request.target()),
            request.amount()
        );
    }
}

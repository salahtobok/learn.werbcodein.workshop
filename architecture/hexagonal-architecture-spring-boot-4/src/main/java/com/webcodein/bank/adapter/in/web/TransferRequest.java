package com.webcodein.bank.adapter.in.web;

import java.math.BigDecimal;

record TransferRequest(Long source, Long target, BigDecimal amount) {
}

package com.controller;

import com.entity.Transaction;
import com.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/filterByAmount")
    List<Transaction> getAccountTransactionByAmount(@RequestParam Long clientId, @RequestParam(required = false) Long accountId, @RequestParam Double amount) {
        if(accountId == null)
            return transactionService.getClientTransactionByAmount(clientId, amount);
        else
            return transactionService.getAccountTransactionByAmount(clientId, accountId, amount);
    }
}

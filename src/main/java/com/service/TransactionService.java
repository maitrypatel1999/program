package com.service;

import com.entity.Transaction;
import com.repo.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountGroupService accountGroupService;
    private final AccountService accountService;


    public List<Transaction> getAccountTransactionByAmount(Long clientId, Long accountId, Double amount) {
      return  accountGroupService.getAccountGroupByClientId(clientId).stream().
                filter(accountGroup -> accountGroup != null).
                map(accountGroup -> accountService.getAccountByGroupIdAndAccountId(accountGroup.getId(), accountId)).
                filter(account -> account != null).
                map(account -> transactionRepository.findByAccountIdAndTransactionAmountGreaterThan(accountId, amount)).
                flatMap(List::stream).collect(Collectors.toList());
    }

    public List<Transaction> getClientTransactionByAmount(Long clientId, Double amount) {
        return accountGroupService.getAccountGroupByClientId(clientId).stream().
                filter(accountGroup -> accountGroup != null).
                map(accountGroup -> accountService.getAccountByGroupIdAndClientId(accountGroup.getId(), clientId)).
                flatMap(Collection::stream).
                filter(account -> account != null).
                map(account -> transactionRepository.findByAccountIdAndTransactionAmountGreaterThan(account.getId(), amount)).
                flatMap(List::stream).collect(Collectors.toList());
    }



}


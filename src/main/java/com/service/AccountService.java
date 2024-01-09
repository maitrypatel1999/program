package com.service;

import com.entity.Account;
import com.errors.ItemNotFoundException;
import com.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountGroupService accountGroupService;

    public List<Account> getAllAccountBalance(Long clientId, Long id, Double accountBalance) {
       return accountGroupService.getAccountGroupByClientId(clientId).stream().
                filter(accountGroup -> accountGroup != null).
                map(accountGroup -> accountRepository.findByGroupIdAndIdAndAcctBalanceGreaterThan(accountGroup.getId(),id, accountBalance)).
                flatMap(Collection::stream).
               collect(Collectors.toList());
    }

    public List<Account> getAllAccountBalanceByGroup(Long clientId, Double accountBalance) {
        return accountGroupService.getAccountGroupByClientId(clientId).stream().
                filter(accountGroup -> accountGroup != null).
                map(accountGroup -> accountRepository.findByGroupIdAndAcctBalanceGreaterThan(accountGroup.getId(), accountBalance)).
                flatMap(Collection::stream).
                collect(Collectors.toList());
    }


    //  return accountGroupService.getAccountGroupByClientId(clientId).stream().
    //      filter(accountGroup -> accountGroup != null).
    //     map(accountGroup -> accountService.getAccountByGroupIdAndClientId(accountGroup.getId(), clientId)).
    //     flatMap(Collection::stream).
    

    public List<Account> accounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAccountByGroupIdAndClientId(Long groupId, Long clientId) {
        return accountRepository.findByGroupIdAndClientId(groupId, clientId);
    }

    public Account getAccountByGroupIdAndAccountId(Long groupId, Long accountId) {
        return accountRepository.findByGroupIdAndId(groupId, accountId);
    }

    public Account getAccountById(Long id) {

        return accountRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Account getHighestAccountBalance() {
        return accountRepository.findTopByOrderByAcctBalanceDesc();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateOrCreateAccount(Account account) {

        return accountRepository.findById(account.getId())
                .map(a -> {
                    a.setAcctHolder(account.getAcctHolder());
                    a.setAcctName(account.getAcctName());
                    a.setAcctNumber(account.getAcctNumber());
                    a.setAcctType(account.getAcctType());
                    a.setAcctBalance(account.getAcctBalance());
                    return accountRepository.saveAndFlush(a);
                })
                .orElseGet(() -> {
                    return accountRepository.saveAndFlush(account);
                });
    }
}


//  return accountGroupService.getAccountGroupByClientId(clientId).stream().
  //      filter(accountGroup -> accountGroup != null).
   //     map(accountGroup -> accountService.getAccountByGroupIdAndClientId(accountGroup.getId(), clientId)).
   //     flatMap(Collection::stream).
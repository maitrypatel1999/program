package com.controller;

import com.entity.Account;
import com.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/filterByAccountBalance")
    List<Account> getAllAccountBalance(@RequestParam Long clientId, @RequestParam(required = false) Long id, @RequestParam Double accountBalance)
    {
        if(id == null)
            return accountService.getAllAccountBalanceByGroup(clientId, accountBalance);
        else
            return accountService.getAllAccountBalance(clientId, id, accountBalance);
    }

    @GetMapping("")
    List<Account> accounts() {
        return accountService.accounts();
    }

    @GetMapping("/{id}")
    Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/highest")
    Account getHighestAccountBalance() {
        return accountService.getHighestAccountBalance();
    }

    @PostMapping("")
    Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("")
    Account updateOrCreateAccount(@RequestBody Account account) {
        return accountService.updateOrCreateAccount(account);
    }

    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}

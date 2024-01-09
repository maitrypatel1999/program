package com.controller;

import com.entity.AccountGroup;
import com.service.AccountGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/accountgroup")
@RequiredArgsConstructor
public class AccountGroupController {

    private final AccountGroupService accountGroupService;

    @GetMapping("")
    List<AccountGroup> accounts() {
        return accountGroupService.accountgroupss();
    }

    @GetMapping("/{id}")
    AccountGroup getAccountById(@PathVariable Long id) {
        return accountGroupService.getAccountGroupById(id);
    }

    @PostMapping("")
    AccountGroup createAccountGroup(@Valid @RequestBody AccountGroup accountGroup) {
        return accountGroupService.createAccountGroup(accountGroup);
    }

    @PutMapping("")
    AccountGroup updateOrCreateAccountGroup(@RequestBody AccountGroup accountGroup) {
        return accountGroupService.updateOrCreateAccountGroup(accountGroup);
    }

    @DeleteMapping("/{id}")
    void deleteAccountGroup(@PathVariable Long id) {
        accountGroupService.deleteAccountGroup(id);
    }

}


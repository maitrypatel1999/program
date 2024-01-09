package com.service;

import com.entity.AccountGroup;
import com.errors.ItemNotFoundException;
import com.repo.AccountGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountGroupService {

    private final AccountGroupRepository accountGroupRepository;

    public List<AccountGroup> accountgroupss() {
        return accountGroupRepository.findAll();
    }

    public List<AccountGroup> getAccountGroupByClientId(Long clientId) {
        return accountGroupRepository.findByClientId(clientId);
    }

    public AccountGroup getAccountGroupByClientId(Long clientId, Long groupId) {
        return accountGroupRepository.findByClientIdAndId(clientId, groupId);
    }

    public AccountGroup getAccountGroupById(Long id) {

        return accountGroupRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public AccountGroup createAccountGroup(AccountGroup account) {
        return accountGroupRepository.save(account);
    }

    public void deleteAccountGroup(Long id) {
        accountGroupRepository.deleteById(id);
    }

    public AccountGroup updateOrCreateAccountGroup(AccountGroup accountGroup) {

        return accountGroupRepository.findById(accountGroup.getId())
                .map(a -> {
                    a.setClientId(accountGroup.getClientId());
                    a.setDataSourceId(accountGroup.getDataSourceId());
                    a.setId(accountGroup.getId());
                    a.setDataSourceName(accountGroup.getDataSourceName());
                    return accountGroupRepository.saveAndFlush(a);
                })
                .orElseGet(() -> {
                    return accountGroupRepository.saveAndFlush(accountGroup);
                });
    }
}


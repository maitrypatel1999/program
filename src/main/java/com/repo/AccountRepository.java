package com.repo;

import com.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findTopByOrderByAcctBalanceDesc();
    Account findByGroupIdAndId(Long groupId, Long accountId);
    List<Account> findByGroupIdAndClientId(Long groupId, Long clientId);
    List<Account> findByGroupIdAndIdAndAcctBalanceGreaterThan(Long groupId, Long id, Double accountBalance);
    List<Account> findByGroupIdAndAcctBalanceGreaterThan(Long groupId, Double accountBalance);

}

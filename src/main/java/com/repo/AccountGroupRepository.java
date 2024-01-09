package com.repo;

import com.entity.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountGroupRepository extends JpaRepository<AccountGroup, Long> {

    List<AccountGroup> findByClientId(Long clientId);

    AccountGroup findByClientIdAndId(Long clientId, Long groupId);
}

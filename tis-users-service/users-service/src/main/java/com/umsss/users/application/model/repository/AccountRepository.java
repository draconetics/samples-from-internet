package com.umsss.users.application.model.repository;

import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    @Query("select item from Account item where item.email = :email and item.state = :state")
    List<Account> findAccount(@Param("email") String email, @Param("state") AccountState state);
    // List<Account> findByEmailAndState(String email, AccountState state);

    List<Account> findByStateOrderByCreatedDateDesc(AccountState state);
}

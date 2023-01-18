package org.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}

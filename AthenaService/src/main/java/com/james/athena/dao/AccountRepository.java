package com.james.athena.dao;

import com.james.athena.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by haozhexu on 1/29/17.
 */
public interface AccountRepository extends JpaRepository<Account, String> {
}

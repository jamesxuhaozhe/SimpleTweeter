package com.james.athena.handler;

import com.james.athena.dao.AccountRepository;
import com.james.athena.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haozhexu on 1/29/17.
 */
public class UserHandler {

    @Autowired
    private AccountRepository userRepo;

    public List<Account> getAll() {
        List<Account> results = new ArrayList<>();
        userRepo.findAll().forEach(results::add);
        return results;
    }
}

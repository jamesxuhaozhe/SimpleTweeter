package com.james.athena;

import com.james.athena.dao.AccountRepository;
import com.james.athena.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by haozhexu on 1/29/17.
 */
@Component
public class UserDatabaseInitializer implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    private static final List<Account> accounts = new ArrayList<>();

    static {
        Stream.of(new Account().setEmailAddress("emailAddress1").setPassword("password1").setPhoneNumber("phoneNumber1").setUsername("username1"),
                new Account().setEmailAddress("emailAddress2").setPassword("password2").setPhoneNumber("phoneNumber2").setUsername("username2"),
                new Account().setEmailAddress("emailAddress3").setPassword("password3").setPhoneNumber("phoneNumber3").setUsername("username3"))
        .forEach(accounts::add);
    }

    @Override
    public void run(String... args) throws Exception {
        accounts.forEach(accountRepository::save);
    }
}

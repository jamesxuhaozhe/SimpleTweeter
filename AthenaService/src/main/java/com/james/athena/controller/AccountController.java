package com.james.athena.controller;

import com.james.athena.entity.Account;
import com.james.athena.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haozhexu on 1/29/17.
 */
@RestController
public class AccountController {

    @Autowired
    private UserHandler userHandler;

    @RequestMapping(value = "/all")
    public List<Account> getAll() {
        return userHandler.getAll();
    }
}

package com.james.zeus.controller;

import com.james.zeus.handler.TweetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haozhexu on 1/26/17.
 */
@RestController
public class TweetController {

    @Autowired
    private TweetHandler tweetHandler;

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return tweetHandler.printHelloWorld();
    }
}

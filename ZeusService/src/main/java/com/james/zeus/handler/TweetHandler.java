package com.james.zeus.handler;

import com.james.zeus.dao.TweetDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by haozhexu on 1/26/17.
 */
public class TweetHandler {

    @Autowired
    private TweetDAO tweetDAO;

    public String printHelloWorld() {
        return "Hello World";
    }
}

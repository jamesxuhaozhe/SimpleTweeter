package com.james.zeus.controller;

import com.james.zeus.handler.TweetHandler;
import com.james.zeus.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haozhexu on 1/26/17.
 */
@RestController
public class TweetController {

    @Autowired
    private TweetHandler tweetHandler;

    @RequestMapping("/all")
    public List<Tweet> getAll() {
        return tweetHandler.getAll();
    }

    @RequestMapping("/user")
    public List<Tweet> getTweetsByUserId(@RequestParam(value = "id") String id) {
        return tweetHandler.getTweetsByUserId(id);
    }
}

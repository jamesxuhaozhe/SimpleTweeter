package com.james.zeus.controller;

import com.james.zeus.handler.TweetHandler;
import com.james.zeus.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MainController that contains all the api we expose to the ZeusService Client
 * Created by haozhexu on 1/26/17.
 */
@RestController
public class TweetController {

    @Autowired
    private TweetHandler tweetHandler;

    /**
     * Gets all the tweets from our database
     * @return a list of all tweets from our database
     */
    @RequestMapping("/all")
    public List<Tweet> getAll() {
        return tweetHandler.getAll();
    }

    /**
     * Get a list of tweets by user id.
     * @param id user id in question
     * @return a list of tweets by user id
     */
    @RequestMapping("/user")
    public List<Tweet> getTweetsByUserId(@RequestParam(value = "id") String id) {
        return tweetHandler.getTweetsByUserId(id);
    }
}

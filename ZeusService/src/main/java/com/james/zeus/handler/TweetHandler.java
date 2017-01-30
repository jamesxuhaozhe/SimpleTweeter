package com.james.zeus.handler;

import com.james.zeus.dao.TweetDAO;
import com.james.zeus.dto.TweetItem;
import com.james.zeus.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by haozhexu on 1/26/17.
 */
public class TweetHandler {

    @Autowired
    private TweetDAO tweetDAO;

    public List<Tweet> getAll() {
        List<TweetItem> tweetItemsDB = tweetDAO.getAll();
        return tweetItemsDB
                .stream()
                .map(Tweet::fromTweetItem)
                .collect(Collectors.toList());
    }

    public List<Tweet> getTweetsByUserId(String id) {
        List<TweetItem> tweetItems = tweetDAO.getTweetsByUserId(id);
        return tweetItems.stream()
                .map(Tweet::fromTweetItem)
                .collect(Collectors.toList());
    }
}

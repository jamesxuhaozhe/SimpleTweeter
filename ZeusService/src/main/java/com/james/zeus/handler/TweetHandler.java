package com.james.zeus.handler;

import com.james.zeus.dao.TweetDAO;
import com.james.zeus.dto.TweetItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by haozhexu on 1/26/17.
 */
public class TweetHandler {

    @Autowired
    private TweetDAO tweetDAO;

    public List<TweetItem> getAll() {
        return tweetDAO.getAllTweets();
    }
}

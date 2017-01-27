package com.james.zeus.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.james.zeus.dto.TweetItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * Created by haozhexu on 1/27/17.
 */
public class TweetDAO implements ITweetDAO {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public void saveTweet(TweetItem tweetItem) {

    }

    @Override
    public List<TweetItem> getAllTweets() {
        return Collections.emptyList();
    }

    @Override
    public void deleteTweet(TweetItem tweetItem) {

    }
}

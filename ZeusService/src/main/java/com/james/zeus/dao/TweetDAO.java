package com.james.zeus.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
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
        dynamoDBMapper.save(tweetItem);
    }

    @Override
    public List<TweetItem> getAllTweets() {
        List<TweetItem> tweets = dynamoDBMapper.scan(TweetItem.class, new DynamoDBScanExpression());
        return tweets;
    }

    @Override
    public void deleteTweet(TweetItem tweetItem) {

    }
}

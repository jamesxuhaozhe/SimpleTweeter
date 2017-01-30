package com.james.zeus.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.james.zeus.dto.TweetItem;
import com.james.zeus.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
    public List<TweetItem> getAll() {
        List<TweetItem> result = new ArrayList<>();
        List<TweetItem> tweets = dynamoDBMapper.scan(TweetItem.class, new DynamoDBScanExpression());
        // we need to do this the list return from the mapper is unmodifiable
        result.addAll(tweets);
        return result;
    }

    @Override
    public List<TweetItem> getTweetsByUserId(String id) {
        List<TweetItem> tweetItems = getAll();
        List<TweetItem> result = new ArrayList<>();
        tweetItems.forEach(tweetItem -> {
            if (tweetItem.getUserId().equals(id)) {
                result.add(tweetItem);
            }
        });
        return result;
    }

    @Override
    public void deleteTweet(TweetItem tweetItem) {
        // no-op
    }
}

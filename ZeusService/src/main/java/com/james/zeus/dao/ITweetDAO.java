package com.james.zeus.dao;

import com.james.zeus.dto.TweetItem;
import com.james.zeus.model.Tweet;

import java.util.List;

/**
 * Interface that define all the methods or functionalities we
 * would like to have on top of the dynamodb
 * Created by haozhexu on 1/26/17.
 */
public interface ITweetDAO {
    /**
     * Gets all the tweets from our dynamodb
     * @return all the tweets from our dynamodb
     */
    List<TweetItem> getAll();

    /**
     * Gets a list of tweets by user id
     * @param id user id in question
     * @return a list tweets made by user in question
     */
    List<TweetItem> getTweetsByUserId(String id);
}

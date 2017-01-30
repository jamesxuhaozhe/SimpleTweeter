package com.james.zeus.dao;

import com.james.zeus.dto.TweetItem;
import com.james.zeus.model.Tweet;

import java.util.List;

/**
 * Created by haozhexu on 1/26/17.
 */
public interface ITweetDAO {

    void saveTweet(TweetItem tweetItem);

    List<TweetItem> getAll();

    List<TweetItem> getTweetsByUserId(String id);

    void deleteTweet(TweetItem tweetItem);
}

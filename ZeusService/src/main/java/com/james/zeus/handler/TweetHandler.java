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
                .map(tweetItem -> new Tweet()
                        .setId(tweetItem.getId())
                        .setUserId(tweetItem.getUserId())
                        .setContent(tweetItem.getContent())
                        .setCreatedTimeStamp(tweetItem.getCreatedTimeStamp()))
                .collect(Collectors.toList());
    }
}

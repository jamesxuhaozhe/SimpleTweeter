package com.james.zeus.model;

import com.james.zeus.dto.TweetItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * POJO of tweet that contains all the information we need expose to the service client.
 * Currently it looks kinda the same with {@link com.james.zeus.dto.TweetItem}, however we
 * expect they may diverge in the future. Since {@link com.james.zeus.dto.TweetItem} is expected
 * to have more implementation details that client might not be or should not be interested.
 * Created by haozhexu on 1/29/17.
 */
@Data
@Accessors(chain = true)
public class Tweet {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long createdTimeStamp;

    @Getter
    @Setter
    private String content;

    public static Tweet fromTweetItem(TweetItem tweetItem) {
        return new Tweet()
                .setId(tweetItem.getId())
                .setUserId(tweetItem.getUserId())
                .setContent(tweetItem.getContent())
                .setCreatedTimeStamp(tweetItem.getCreatedTimeStamp());
    }
}

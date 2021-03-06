package com.james.zeus.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * Data transfer object that we use to talk to the dynamodb
 * Created by haozhexu on 1/26/17.
 */
@DynamoDBTable(tableName = "Tweets")
public class TweetItem {
    private String id;
    private String userId;
    private Long createdTimeStamp;
    private String content;

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public TweetItem setId(String id) {
        this.id = id;
        return this;
    }

    @DynamoDBRangeKey(attributeName = "UserId")
    public String getUserId() {
        return userId;
    }

    public TweetItem setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @DynamoDBRangeKey(attributeName = "CreatedTimeStamp")
    public Long getCreatedTimeStamp() {
        return this.createdTimeStamp;
    }

    public TweetItem setCreatedTimeStamp(Long createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
        return this;
    }

    @DynamoDBAttribute(attributeName = "Content")
    public String getContent() {
        return this.content;
    }

    public TweetItem setContent(String content) {
        this.content = content;
        return this;
    }


}

package com.james.zeus.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.james.zeus.dao.TweetDAO;
import com.james.zeus.handler.TweetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haozhexu on 1/26/17.
 */
@Configuration
public class Config {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient();
        dynamoDB.setEndpoint("http://localhost:8000");
        return new DynamoDBMapper(dynamoDB);
    }

    @Bean
    public TweetDAO tweetDAO() {
        return new TweetDAO();
    }

    @Bean
    public TweetHandler tweetHandler() {
        return new TweetHandler();
    }
}

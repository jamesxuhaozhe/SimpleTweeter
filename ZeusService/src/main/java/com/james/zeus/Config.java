package com.james.zeus;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.james.zeus.dao.TweetDAO;
import com.james.zeus.handler.TweetHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Central configuration class that define how bean can be created.
 * Back in the old days, you need write this kind of stuff in xml.
 * Now you can write this in the java code and add annotations
 * Created by haozhexu on 1/26/17.
 */
@Configuration
public class Config {

    @Value("${amazon.aws.accesskey}")
    private String awsAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String awsSecretKey;

    @Value("${amazon.dynamodb.endpoint}")
    private String awsEndpoint;

    @Value("${amazon.aws.regionoverride}")
    private String awsRegionOverride;

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDBClient amazonDynamoDBClient) {
        return new DynamoDBMapper(amazonDynamoDBClient);
    }

    @Bean
    public AmazonDynamoDBClient amazonDynamoDBClient() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient(awsCredentials);
        amazonDynamoDBClient.setEndpoint(awsEndpoint);
        amazonDynamoDBClient.setSignerRegionOverride(awsRegionOverride);

        return amazonDynamoDBClient;
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

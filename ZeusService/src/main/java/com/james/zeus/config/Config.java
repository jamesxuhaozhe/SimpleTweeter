package com.james.zeus.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.james.zeus.dao.TweetDAO;
import com.james.zeus.dto.TweetItem;
import com.james.zeus.handler.TweetHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDBClient);
        //CreateTableRequest request = mapper.generateCreateTableRequest(TweetItem.class);
        //request.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        //amazonDynamoDBClient.createTable(request);
        return mapper;
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

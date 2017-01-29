package com.james.zeus;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.james.zeus.dto.TweetItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Because this class is annotated with @component and implements
 * {@link CommandLineRunner}, what ever code put in the run method
 * will automatically gets run when Spring boots up!
 * I am using DynamoDBLocal only testing and dev purpose because I am
 * cheap!! Just can not afford a real DynamoDB now.
 * Created by haozhexu on 1/28/17.
 */
@Component
public class DynamoDBLocalInitializer implements CommandLineRunner {

    @Autowired
    private AmazonDynamoDBClient amazonDynamoDBClient;

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public void run(String... args) throws Exception {
        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(TweetItem.class);
        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(100L, 100L));
        amazonDynamoDBClient.createTable(createTableRequest);

        dynamoDBMapper.save(new TweetItem().setUserId("fooId").setCreatedTimeStamp(System.currentTimeMillis()));
    }
}

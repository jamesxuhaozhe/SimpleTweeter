package com.james.zeus;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.james.zeus.dto.TweetItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    private static List<TweetItem> testTweets = new ArrayList<>();

    static {
        Stream.of(new TweetItem().setUserId("James").setContent("James is quite happy about the project").setCreatedTimeStamp(System.currentTimeMillis()),
                new TweetItem().setUserId("Susen").setContent("Susen is working at Google and coding his epic project").setCreatedTimeStamp(System.currentTimeMillis()),
                new TweetItem().setUserId("WenHao").setContent("WenHao is very smart and working at SnapChat").setCreatedTimeStamp(System.currentTimeMillis()))
                .forEach(testTweets::add);
    }

    /**
     * The method will be called when spring project gets boot up.
     * It creates the tweet table in memory and populate the table with some
     * data so we can start developing.
     * @param args arguments from the command line
     * @throws Exception when something I am not fully aware of happened
     */
    @Override
    public void run(String... args) throws Exception {
        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(TweetItem.class);
        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(100L, 100L));
        amazonDynamoDBClient.createTable(createTableRequest);

        // populate our db with some test data so we can start playing around
        populateDynamoDBLocal();
    }

    /**
     * Populates the db with some test data
     */
    private void populateDynamoDBLocal() {
        testTweets.forEach(dynamoDBMapper::save);
    }
}

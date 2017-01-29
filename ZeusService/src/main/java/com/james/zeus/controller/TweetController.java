package com.james.zeus.controller;

import com.james.zeus.dto.TweetItem;
import com.james.zeus.handler.TweetHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haozhexu on 1/26/17.
 */
@RestController
public class TweetController {

    @Autowired
    private TweetHandler tweetHandler;

    @RequestMapping("/helloWorld")
    public String helloWorld() {

        try
        {
         tweetHandler.haha();
        }catch (Exception e)
        {
            return e.getMessage();
        }

        return "hello World";
    }

    @RequestMapping("/all")
    public List<TweetItem> getAll() {
        return tweetHandler.getAll();
    }
}

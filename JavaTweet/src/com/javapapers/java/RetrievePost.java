package com.javapapers.java;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class RetrievePost {



    public static void main(String[] args) throws IOException {

        FileReader filereader = new FileReader("/Users/rohan.sinha/IdeaProjects/JavaTweet/Resource/config.properties");
        Properties properties=new Properties();

        properties.load(filereader);
        String consumerKeyStr=properties.getProperty("consumer.key");
        String cousumerSecretStr=properties.getProperty("consumer.secret");
        String accessTokenStr=properties.getProperty("accesstoken.key");
        String accessTokenSecretStr=properties.getProperty("accesstoken.secret");
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true);
        configurationBuilder.setOAuthConsumerKey(consumerKeyStr);
        configurationBuilder.setOAuthConsumerSecret(cousumerSecretStr);
        configurationBuilder.setOAuthAccessToken(accessTokenStr);
        configurationBuilder.setOAuthAccessTokenSecret(accessTokenSecretStr);

        Configuration configuration = configurationBuilder.build();
        Twitter twitter = new TwitterFactory(configuration).getInstance();
        try {
            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1, 20));
            for (Status b : a) {
                System.out.println(b.getText());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }




}

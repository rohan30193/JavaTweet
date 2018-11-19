package com.javapapers.java;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.FileReader;
import java.util.Properties;

public class TweetJava {



    public static void main(String[] args) throws Exception {

        try {

            FileReader filereader = new FileReader("/Users/rohan.sinha/IdeaProjects/JavaTweet/Resource/config.properties");
            Properties properties=new Properties();

            properties.load(filereader);
             String consumerKeyStr=properties.getProperty("consumer.key");
             String cousumerSecretStr=properties.getProperty("consumer.secret");
             String accessTokenStr=properties.getProperty("accesstoken.key");
             String accessTokenSecretStr=properties.getProperty("accesstoken.secret");


            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(consumerKeyStr,cousumerSecretStr);
            AccessToken accessToken=new AccessToken(accessTokenStr,accessTokenSecretStr);
            twitter.setOAuthAccessToken(accessToken);
            twitter.updateStatus("12th Nov updating through twitter4j");
            System.out.println("successfully updated status again");
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
        }
    }

}

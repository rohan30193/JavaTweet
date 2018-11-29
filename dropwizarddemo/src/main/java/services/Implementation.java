package services;


import com.yammer.dropwizard.Response;
import com.yammer.dropwizard.TwitterResource;
import models.TwitterPostInfoPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.*;


public class Implementation {

    private static Implementation IMPLEMENTATION_INSTANCE=null;

    public Implementation(){};

    public static Implementation getInstance()
    {
        if(IMPLEMENTATION_INSTANCE==null)
        {
            synchronized (Implementation.class)
            {
                if(IMPLEMENTATION_INSTANCE==null)
                    IMPLEMENTATION_INSTANCE=new Implementation();
            }

        }
        return IMPLEMENTATION_INSTANCE;
    }

    private final Logger slf4jLogger= LoggerFactory.getLogger(TwitterResource.class);

    private  String consumerKeyStr="";
    private  String cousumerSecretStr="";
    private  String accessTokenStr="";
    private  String accessTokenSecretStr="";
    private  String debugStatus="";

    private   void keyTokenInitializer() {


        try {

            FileReader filereader = new FileReader("/Users/rohan.sinha/IdeaProjects/dropwizarddemo/src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(filereader);
            consumerKeyStr = properties.getProperty("consumer.key");
            cousumerSecretStr = properties.getProperty("consumer.secret");
            accessTokenStr = properties.getProperty("accesstoken.key");
            accessTokenSecretStr = properties.getProperty("accesstoken.secret");
            debugStatus = properties.getProperty("debug");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Response tweetMessage(String tweet)
    {
        slf4jLogger.info("Entering into the tweet method");

        keyTokenInitializer();
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);

        try{


            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(Boolean.parseBoolean(debugStatus))
                    .setOAuthConsumerKey(consumerKeyStr)
                    .setOAuthConsumerSecret(cousumerSecretStr)
                    .setOAuthAccessToken(accessTokenStr)
                    .setOAuthAccessTokenSecret(accessTokenSecretStr);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();



            Status status = twitter.updateStatus(tweet);
            result.setMessage("Successfully updated the status to [" + status.getText() + "].");
            result.setSuccess(Boolean.TRUE);


            slf4jLogger.info("Message successfully tweeted at the Timeline");
        }
        catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }

    public Response getTimeline()
    {
        slf4jLogger.info("Entering into the getTimeline method");

        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        keyTokenInitializer();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(Boolean.parseBoolean(debugStatus))
                .setOAuthConsumerKey(consumerKeyStr)
                .setOAuthConsumerSecret(cousumerSecretStr)
                .setOAuthAccessToken(accessTokenStr)
                .setOAuthAccessTokenSecret(accessTokenSecretStr);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();


        TwitterPostInfoPojo twitterPostInfoPojo=new TwitterPostInfoPojo();
        try {
            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1, 20));
            for (Status b : a) {
                System.out.println(b.getText());
                twitterPostInfoPojo.setUserName(b);
                System.out.println(twitterPostInfoPojo.getUserName());
                twitterPostInfoPojo.setCreationDate(b);
                System.out.println(twitterPostInfoPojo.getCreationDate());
                twitterPostInfoPojo.setTwitterHandle(b);
                System.out.println(twitterPostInfoPojo.getTwitterHandle());
                twitterPostInfoPojo.setProfileImgUrl(b);
                System.out.println(twitterPostInfoPojo.getProfileImgUrl());
            }
            slf4jLogger.info("Got Tweets from Timeline");

        } catch (Exception e) {
            System.out.println(e);
        }
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public Response getFilteredTweets(final String filterTweet)
    {
        slf4jLogger.info("Entering into the getFilteredTweets method");

        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);
        keyTokenInitializer();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(Boolean.parseBoolean(debugStatus))
                .setOAuthConsumerKey(consumerKeyStr)
                .setOAuthConsumerSecret(cousumerSecretStr)
                .setOAuthAccessToken(accessTokenStr)
                .setOAuthAccessTokenSecret(accessTokenSecretStr);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try
        {
            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1, 100));
            ArrayList<String> arrayList=new ArrayList<String>();
            for (Status b:a) {
                arrayList.add(b.getText());
            }
            arrayList.stream().filter(message -> message.contains(filterTweet)).collect(Collectors.toList()).forEach(System.out::println);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        result.setSuccess(Boolean.TRUE);
        return result;
    }

}

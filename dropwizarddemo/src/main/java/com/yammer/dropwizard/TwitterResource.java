package com.yammer.dropwizard;

import com.yammer.metrics.annotation.Timed;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

@Path("/api/1.0/twitter/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterResource {


    private String consumerKeyStr="";
    private String cousumerSecretStr="";
    private String accessTokenStr="";
    private String accessTokenSecretStr="";
    private String debugStatus="";
    private void key_token_initializer()
    {
        try{

            FileReader filereader = new FileReader("/Users/rohan.sinha/IdeaProjects/dropwizarddemo/src/main/resources/config.properties");
            Properties properties=new Properties();
            properties.load(filereader);
            consumerKeyStr=properties.getProperty("consumer.key");
            cousumerSecretStr=properties.getProperty("consumer.secret");
            accessTokenStr=properties.getProperty("accesstoken.key");
            accessTokenSecretStr=properties.getProperty("accesstoken.secret");
            debugStatus=properties.getProperty("debug");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @POST
    public Response tweetMessage(@QueryParam("tweet") String tweet) {

        key_token_initializer();
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
        } catch (TwitterException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }

    @GET
    public Response getTimeline(@QueryParam("tweet") String tweet) throws IOException {

        key_token_initializer();
        Response result = new Response();
        result.setGuid(UUID.randomUUID().toString());
        result.setSuccess(Boolean.FALSE);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(Boolean.parseBoolean(debugStatus))
                .setOAuthConsumerKey(consumerKeyStr)
                .setOAuthConsumerSecret(cousumerSecretStr)
                .setOAuthAccessToken(accessTokenStr)
                .setOAuthAccessTokenSecret(accessTokenSecretStr);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();


        try {
            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1, 20));
            for (Status b : a) {
                System.out.println(b.getText());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        result.setSuccess(Boolean.TRUE);
        return result;
    }


}

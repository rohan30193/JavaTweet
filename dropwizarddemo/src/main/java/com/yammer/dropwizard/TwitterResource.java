package com.yammer.dropwizard;

import com.yammer.metrics.annotation.Timed;
import models.TwitterPostInfoPojo;
import org.slf4j.Logger;
import services.Implementation;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import org.slf4j.LoggerFactory;

@Path("/api/1.0/twitter/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterResource {




    @POST
    public void tweetMessage(@QueryParam("tweet") String tweet) {

        Response res=new Response();
        try
        {

            res.setSuccess(Boolean.FALSE);
            Implementation.getInstance().tweetMessage(tweet);

            res.setSuccess(Boolean.TRUE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }



    }

    @GET
    public void getTimeline(@QueryParam("tweet") String tweet) throws IOException {


        Response res=new Response();
        try
        {
            res.setSuccess(Boolean.FALSE);
            Implementation.getInstance().getTimeline();
            res.setSuccess(Boolean.TRUE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }


    }

    @GET
    @Path("/filter")
    public void getFilteredTweets(@QueryParam("filter") String filter) throws IOException {

        Response res=new Response();
        try
        {
            res.setSuccess(Boolean.FALSE);
            Implementation.getInstance().getFilteredTweets(filter);

            res.setSuccess(Boolean.TRUE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }

    }


}

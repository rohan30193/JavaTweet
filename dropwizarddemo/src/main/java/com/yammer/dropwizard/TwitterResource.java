package com.yammer.dropwizard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testbean.MySpringBeanWithDependency;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Arrays;

@Path("/api/1.0/twitter/tweet")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterResource {


    private MySpringBeanWithDependency mySpringBeanWithDependency;

    public void setMySpringBeanWithDependency(MySpringBeanWithDependency mySpringBeanWithDependency) {
        this.mySpringBeanWithDependency = mySpringBeanWithDependency;
    }

    @POST
    public Response tweetMessage (@QueryParam("tweet") String tweet){


        Response res = new Response();
        try {
            res.setSuccess(Boolean.FALSE);
            res=mySpringBeanWithDependency.runPostTweets(tweet);

            res.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }

        return res;
    }

        @GET
        public Response getTimeline (@QueryParam("tweet") String tweet) throws IOException {


        Response res = new Response();
        try {
            res.setSuccess(Boolean.FALSE);

            res = mySpringBeanWithDependency.runGetTimeline();

            res.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }
        return res;

    }

        @GET
        @Path("/filter")
        public Response getFilteredTweets (@QueryParam("filter") String filter) throws IOException {

        Response res = new Response();
        try {
            res.setSuccess(Boolean.FALSE);

            res=mySpringBeanWithDependency.runFilteredTweets(filter);

            res.setSuccess(Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
            res.setSuccess(Boolean.FALSE);
        }
        return res;

    }

    }



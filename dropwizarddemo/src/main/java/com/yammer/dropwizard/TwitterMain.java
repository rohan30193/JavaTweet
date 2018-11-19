package com.yammer.dropwizard;

import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TwitterMain extends Service<TwitterConfiguration> {

    public static void main(String[] args) throws Exception{
        new TwitterMain().run(args);
    }

    @Override
    public void initialize(Bootstrap<TwitterConfiguration> bootstrap) {

    }
    @Override
    public void run(TwitterConfiguration twitterConfiguration, Environment environment) throws Exception {


        environment.addResource(new TwitterResource());

    }
}

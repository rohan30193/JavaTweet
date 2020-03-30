package com.yammer.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TwitterMain extends Application<TwitterConfiguration> {



    public static void main(String[] args) throws Exception{

        new TwitterMain().run(args);
    }


    @Override
    public void initialize(Bootstrap<TwitterConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/path/", "index.html", "asset1"));
    }

    @Override
    public void run(TwitterConfiguration twitterConfiguration, Environment environment) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        environment.jersey().register(context.getBean("twitterResource", TwitterResource.class));

//        environment.addResource(context.getBean("twitterResource", TwitterResource.class));


    }
}

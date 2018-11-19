package com.yammer.dropwizarddemo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizarddemo.resources.HelloWorldResource;

public class SampleService extends Service<SampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new SampleService().run(args);
    }
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {

    }

    public void run(SampleConfiguration sampleConfiguration, Environment environment) throws Exception {

        environment.addResource(new HelloWorldResource());
    }
}
